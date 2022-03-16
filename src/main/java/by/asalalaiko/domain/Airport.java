package by.asalalaiko.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "name", unique = true)
    private String name;
    @Column
    private BigDecimal tax;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startAirport", fetch = FetchType.LAZY)
    private List<Flight> start_Flight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finishAirport", fetch = FetchType.LAZY)
    private List<Flight> finish_Flight;


    public Airport() {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public List<Flight> getStart_Flight() {
        return start_Flight;
    }

    public void setStart_Flight(List<Flight> start_Flight) {
        this.start_Flight = start_Flight;
    }

    public List<Flight> getFinish_Flight() {
        return finish_Flight;
    }

    public void setFinish_Flight(List<Flight> finish_Flight) {
        this.finish_Flight = finish_Flight;
    }
}
