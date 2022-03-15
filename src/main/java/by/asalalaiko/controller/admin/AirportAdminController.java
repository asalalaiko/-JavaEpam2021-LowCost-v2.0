package by.asalalaiko.controller.admin;

import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;
import by.asalalaiko.service.AirportService;
import by.asalalaiko.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AirportAdminController {

    @Autowired
    private AirportService airportService;
    @Autowired
    private CityService cityService;

    @GetMapping("/admin/airport")
    public String getAllAirport(Model model){
        model.addAttribute("title", "Admin - Airport list");
        model.addAttribute("airport", new Airport());
        model.addAttribute("airports", airportService.getAirports());
        model.addAttribute("cities", cityService.getCities());
        return "/admin/airport";
    }


    @PostMapping("/admin/airport")
    public String addAirport(@Valid Airport airport) {

        airportService.createAirport(airport);

        return "redirect:/admin/airport";
    }

    @GetMapping("/admin/airport/delete")
    public String deleteAirport(@RequestParam(value="id") Long id){
        airportService.deleteById(id);
        return "redirect:/admin/airport";
    }


    @GetMapping("/admin/airport/edit")
    public String getAirportToEdit(@RequestParam(value="id") Long id, Model model) {
        model.addAttribute("title", "Admin - Airport list");
        model.addAttribute("airport", airportService.getAirportById(id));
        model.addAttribute("airports", airportService.getAirports());
        model.addAttribute("cities", cityService.getCities());
        return "/admin/airport";
    }

}
