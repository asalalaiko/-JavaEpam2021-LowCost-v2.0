package by.asalalaiko.controller.admin;



import by.asalalaiko.domain.Plane;
import by.asalalaiko.service.PlaneService;
import by.asalalaiko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class TicketAdminController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/admin/ticket")
    public String getAllPlanes(Model model){
        model.addAttribute("title", "Admin - Ticket list");
       // model.addAttribute("plane", new Plane());
        model.addAttribute("tickets", ticketService.getTickets());
        return "/admin/ticket";
    }


//    @PostMapping("/admin/plane")
//    public String addPlane(@Valid Plane plane) {
//
//        planeService.createPlane(plane);
//
//        return "redirect:/admin/plane";
//    }
//
//    @GetMapping("/admin/plane/delete")
//    public String deletePlane(@RequestParam(value="id") Long id){
//        planeService.deleteById(id);
//        return "redirect:/admin/plane";
//    }
//
//
//
//    @GetMapping("/admin/plane/edit")
//    public String getPlaneToEdit (@RequestParam(value="id") Long id, Model model){
//        model.addAttribute("title", "Admin - Planes list");
//        model.addAttribute("plane", planeService.getPlaneById(id));
//        model.addAttribute("planes", planeService.getPlanes());
//        return "/admin/plane";
//    }


}
