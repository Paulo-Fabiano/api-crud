package com.api.estoque.api_crud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

    @GetMapping
    public ModelAndView viewListaBoleto() {
        ModelAndView mv = new ModelAndView("/boleto/listaBoletos");
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView viweBoletoAdicioanar() {
        ModelAndView mv = new ModelAndView("/boleto/addBoleto");
        return mv;
    }
}
