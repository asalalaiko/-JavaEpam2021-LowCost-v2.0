package by.asalalaiko.controller.admin;


import by.asalalaiko.domain.City;
import by.asalalaiko.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;


@Controller
public class CityAdminController {

    @Autowired
    private CityService cityService;


    @GetMapping("/admin/city")
    public String getAllCities(Model model){
        model.addAttribute("title", "Admin - Cities list");
        model.addAttribute("city", new City());
        model.addAttribute("cities", cityService.getCities());
        return "/admin/city";
    }


    @PostMapping("/admin/city")
    public String addCity(@Valid City city) {

        cityService.createCity(city);

        return "redirect:/admin/city";
    }

    @GetMapping("/admin/city/delete")
    public String deleteCity(@RequestParam(value="id") Long id){
        cityService.deleteById(id);
        return "redirect:/admin/city";
    }



    @GetMapping("/admin/city/edit")
    public String getCityToEdit (@RequestParam(value="id") Long id, Model model){
        model.addAttribute("title", "Admin - Cities list");
        model.addAttribute("city", cityService.getCityById(id));
        model.addAttribute("cities", cityService.getCities());
        return "/admin/city";
    }


}
