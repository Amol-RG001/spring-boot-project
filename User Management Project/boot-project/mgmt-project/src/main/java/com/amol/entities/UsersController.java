package com.amol.entities;

        import java.util.List;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsersController {
    @Autowired
    UserService service;

    public UsersController() {
    }

    @GetMapping({"/users"})
    public String displayUserList(Model model) {
        List<Users> listUsers = this.service.usersList();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping({"/users/new"})
    public String displayNewForm(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping({"/users/save"})
    public String saveUser(Users user, RedirectAttributes ra) {
        this.service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully!");
        return "redirect:/users";
    }

    @GetMapping({"/users/edit/{id}"})
    public String displayEditForm(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        try {
            Users user = this.service.getById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User Id: " + id);
            return "user_form";
        } catch (UserNotFoundException var5) {
            ra.addFlashAttribute("message", "" + var5.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping({"/users/delete/{id}"})
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            this.service.deleteById(id);
            ra.addFlashAttribute("message", "User Id " + id + " deleted successfully!");
        } catch (UserNotFoundException var4) {
            ra.addFlashAttribute("message", var4.getMessage());
        }

        return "redirect:/users";
    }
}
