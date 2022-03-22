package by.asalalaiko.domain;

import javax.persistence.Entity;
import java.util.List;


public class FlightToOrder {
    private Flight flight;
    private Integer quality;


    public FlightToOrder() {
    }

    public FlightToOrder(Flight flight, Integer quality) {
        this.flight = flight;
        this.quality = quality;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}
