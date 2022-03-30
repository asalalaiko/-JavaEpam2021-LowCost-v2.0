package by.asalalaiko.scheduling;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightStatus;
import by.asalalaiko.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ScheduledDailyTasks {

    @Autowired
    private FlightService flightService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledDailyTasks.class);


    //Every At 00:00 recalculation price to flight
    @Scheduled(cron = "0 0 0 * * *") //At 00:00
//   @Scheduled(cron = "0 * * * * *") //At every minute
    public void  recalculationPriceFlight(){
        try {
            LOGGER.info("RecalculationCostTask run.");


            List<Flight> flights = flightService.getFlightsByStatus(FlightStatus.FREE);

        if (flights.size() > 0) {
            flights.stream().forEach(t -> {
                flightService.updateFlightToMidnight(t); });
        }
        } catch (Exception e) {
            LOGGER.error("Error running RecalculationCostTask", e);
        }

    }
}
