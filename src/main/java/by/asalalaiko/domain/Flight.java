package by.asalalaiko.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime finish;
    @Column
    private Integer km;
    @ManyToOne
    @JoinColumn(name = "startAirport_id")
    private Airport startAirport;
    @ManyToOne
    @JoinColumn(name = "finishAirport_id")
    private Airport finishAirport;
    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;
    @Column
    private BigDecimal min_ticket_cost;
    @Column
    private BigDecimal profit;
    @Column
    private BigDecimal ticket_cost;
    @Column
    private BigDecimal costBaggage;
    @Column
    private BigDecimal costPriority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Ticket> tickets;


    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Airport getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    public Airport getFinishAirport() {
        return finishAirport;
    }

    public void setFinishAirport(Airport finishAirport) {
        this.finishAirport = finishAirport;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public BigDecimal getCostBaggage() {
        return costBaggage;
    }

    public void setCostBaggage(BigDecimal costBaggage) {
        this.costBaggage = costBaggage;
    }

    public BigDecimal getCostPriority() {
        return costPriority;
    }

    public void setCostPriority(BigDecimal costPriority) {
        this.costPriority = costPriority;
    }

    public BigDecimal getMin_ticket_cost() {
        return min_ticket_cost;
    }

    public void setMin_ticket_cost(BigDecimal min_ticket_cost) {
        this.min_ticket_cost = min_ticket_cost;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(BigDecimal ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
