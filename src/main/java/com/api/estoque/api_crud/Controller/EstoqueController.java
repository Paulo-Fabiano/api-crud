package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Item;
import com.api.estoque.api_crud.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ModelAndView viewEstoque() {
        List<Item> listaItens = itemService.buscarTodosItens();
        ModelAndView mv = new ModelAndView("/estoque/estoque.html");
        mv.addObject("itens", listaItens);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView viewAdicionar() {
        ModelAndView mv = new ModelAndView("/estoque/adicionar");
        return mv;
    }

}
