package com.api.estoque.api_crud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @GetMapping
    public ModelAndView viewVenda() {
        ModelAndView mv = new ModelAndView("/venda/venda");
        return mv;
    }
}
