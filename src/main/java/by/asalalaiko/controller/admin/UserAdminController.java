package by.asalalaiko.controller.admin;

import by.asalalaiko.domain.User;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    String getUsers(Model model) {
        model.addAttribute("title", "Admin - Users list");
        model.addAttribute("users", userService.findAllUsers());
        return "/admin/users";
    }

   // @PostMapping
}
