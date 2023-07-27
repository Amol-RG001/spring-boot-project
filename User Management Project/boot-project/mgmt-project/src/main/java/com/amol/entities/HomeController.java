
package com.amol.entities;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public HomeController() {
    }

    @GetMapping({"/"})
    public String homePage() {
        return "home";
    }

    @GetMapping({"/form"})
    public String formPage() {
        return "form";
    }
}

