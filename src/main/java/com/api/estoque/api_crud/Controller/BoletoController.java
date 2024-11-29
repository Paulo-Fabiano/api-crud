package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Boleto;
import com.api.estoque.api_crud.Exceptions.BoletoNaoAdicionado;
import com.api.estoque.api_crud.Exceptions.BoletoNaoEncontrado;
import com.api.estoque.api_crud.Service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping
    public String viewListaBoleto(Model model) {
        ModelAndView mv = new ModelAndView("/boleto/listaBoletos");
        List<Boleto> boletos = new ArrayList<>();
        try {
            boletos = boletoService.listarBoleto();
        } catch (BoletoNaoEncontrado e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("boletos", boletos);
        return "redirect:/boleto";
    }

    @GetMapping("/adicionar")
    public ModelAndView viewBoletoAdicioanar() {
        ModelAndView mv = new ModelAndView("/boleto/addBoleto");
        return mv;
    }

    @PostMapping("/api/salvar")
    public String viewAddBoleto(@ModelAttribute  Boleto boleto) {
        ModelAndView mv = new ModelAndView("/boleto/addBoleto");
        try {
            boletoService.adicinarBoleto(boleto);
        } catch (BoletoNaoAdicionado e) {
            throw new RuntimeException(e);
        }
        return "redirect:/boleto/adicionar";
    }
}
