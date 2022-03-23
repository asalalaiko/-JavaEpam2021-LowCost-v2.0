package by.asalalaiko.service;

import by.asalalaiko.domain.City;
import by.asalalaiko.domain.FlightToOrderList;
import by.asalalaiko.domain.Order;
import by.asalalaiko.domain.User;

import java.util.List;

public interface OrderService {

    Order getOrderById (Long id);

    Order createOrder(FlightToOrderList flightToOrderList, User user);

    List<Order> getOrdersByUser(User user);

    void updateOrder(Order order);
}
