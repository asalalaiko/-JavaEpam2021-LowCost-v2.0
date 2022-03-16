package by.asalalaiko.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "name", unique = true)
    private String name;
    @NotNull
    @Column(name = "model")
    private String model;
    @Column
    private Integer passenger_seats;
    @Column
    private BigDecimal cost_1km;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane", fetch = FetchType.LAZY)
    private List<Flight> flights;


    public Plane() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPassenger_seats() {
        return passenger_seats;
    }

    public void setPassenger_seats(Integer passenger_seats) {
        this.passenger_seats = passenger_seats;
    }

    public BigDecimal getCost_1km() {
        return cost_1km;
    }

    public void setCost_1km(BigDecimal cost_1km) {
        this.cost_1km = cost_1km;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
