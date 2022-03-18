package by.asalalaiko.controller.admin;

import by.asalalaiko.domain.User;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    @GetMapping("/admin/user")
    String getUser(@RequestParam(required = false) String id, Model model) {

        if (id!=null){

            model.addAttribute("title", "Admin - User");
            model.addAttribute("user", userService.getUser(Long.valueOf(id)));}

            return "/admin/user";
    }


//     @PostMapping ("/admin/user")
//     String saveUser(@Valid User user, BindingResult bindingResult) {
//
//        userService.saveUser(user);
//
//         return "/admin/users";
//     }
        @PostMapping ("/admin/user/edit")
        String editUser(@RequestParam (value="id") Long id, @RequestParam String login) {
            User user = userService.getUser(id);
            user.setLogin(login);
            userService.saveUser(user);

            return "/admin/users";
}



}
