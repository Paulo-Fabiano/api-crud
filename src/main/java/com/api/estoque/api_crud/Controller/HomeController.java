package com.api.estoque.api_crud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    /*
        Controller que chama meu index.html
     */

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("layout");
    }

}
