package by.asalalaiko.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal cost;
    @Column
    private BigDecimal costBaggage;
    @Column
    private BigDecimal costPriority;

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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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


}
