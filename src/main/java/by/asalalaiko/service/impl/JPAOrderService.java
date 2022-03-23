package by.asalalaiko.service.impl;


import by.asalalaiko.domain.*;
import by.asalalaiko.repo.OrderRepo;
import by.asalalaiko.repo.TicketRepo;
import by.asalalaiko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JPAOrderService implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private TicketRepo ticketRepo;


    @Override
    public Order getOrderById(Long id) {
        return orderRepo.getOne(id);
    }

    @Override
    @Transactional
    public Order createOrder(FlightToOrderList flightToOrderList, User user) {
        Order order = new Order();
        order.setStatus(OrderStatus.BOOKED);
        order.setUser(user);
        orderRepo.save(order);

        flightToOrderList.getFlightToOrders()
                .stream()
                .forEach(flightToOrder -> {
                    ticketRepo.findByFlightAndStatus(flightToOrder.getFlight(), TicketStatus.FREE)
                                .stream()
                                .limit(flightToOrder.getQuality())
                                .forEach(ticket -> {
                                    ticket.setStatus(TicketStatus.BOOKED);
                                    ticket.setOrder(order);
                                    ticketRepo.save(ticket);
                                    });});
        return order;

    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        return orderRepo.findAllByUser(user);
    }


    @Override
    public void updateOrder(Order order) {

    }
}
