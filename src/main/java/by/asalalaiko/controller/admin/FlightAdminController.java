package by.asalalaiko.controller.admin;




import by.asalalaiko.domain.Flight;
import by.asalalaiko.service.AirportService;
import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class FlightAdminController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private PlaneService planeService;


    @GetMapping("/admin/flight")
    public String getAllFlights(Model model){
        model.addAttribute("title", "Admin - Flight list");
        model.addAttribute("flight", new Flight());
        model.addAttribute("flights", flightService.getFlights());
        model.addAttribute("airports", airportService.getAirports());
        model.addAttribute("planes", planeService.getPlanes());
        return "/admin/flight";
    }


    @PostMapping("/admin/flight")
    public String addFlight(@Valid Flight flight) {

        flightService.createFlight(flight);

        return "redirect:/admin/flight";
    }

    @GetMapping("/admin/flight/delete")
    public String deleteFlight(@RequestParam(value="id") Long id){
        flightService.deleteById(id);
        return "redirect:/admin/flight";
    }



    @GetMapping("/admin/flight/edit")
    public String getFlightToEdit (@RequestParam(value="id") Long id, Model model){
        model.addAttribute("title", "Admin - Flight list");
        model.addAttribute("flight", flightService.getFlightById(id));
        model.addAttribute("flights", flightService.getFlights());
        return "/admin/flight";
    }


}
