package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Venda;
import com.api.estoque.api_crud.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ModelAndView viewVenda() {
        ModelAndView mv = new ModelAndView("/venda/listaVendas");
        List<Venda> vendas = vendaService.listarVendas();
        return mv;
    }

    @PostMapping("/api")
    public void registrarVenda(@RequestBody Venda venda) {
        vendaService.registrarVenda(venda);
    }

    @GetMapping("/adicionar")
    public ModelAndView viewAddVenda() {
        ModelAndView mv = new ModelAndView("/venda/addVenda");
        return mv;
    }

}
