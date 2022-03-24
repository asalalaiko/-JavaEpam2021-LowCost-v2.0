package by.asalalaiko.scheduling;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightStatus;
import by.asalalaiko.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.List;

@EnableScheduling
public class ScheduledDailyTasks {

    @Autowired
    private FlightService flightService;


//    @Scheduled(cron = "@midnight")
    @Scheduled(cron = "@hourly")
    public void  recalculationPriceFlight(){
        try {
        List<Flight> flights = flightService.getFlightsByStatus(FlightStatus.FREE);
        if (flights.size() > 0) {
            flights.stream().forEach(t -> {
                flightService.updateFlightToMidnight(t); });
        }
        } catch (Exception e) {
//            LOGGER.error("Error running RecalculationCostTask", e);
        }

    }
}
