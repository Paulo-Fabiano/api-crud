package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Item;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
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
        ModelAndView mv = new ModelAndView("estoque/estoque");
        mv.addObject("itens", listaItens);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView viewAdicionar() {
        ModelAndView mv = new ModelAndView("estoque/adicionar");
        return mv;
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView viewAtualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("estoque/atualizar");
        try {
            // Busca o item pelo ID
            Item item = itemService.buscarItemPorId(id);
            // Adiciona o item ao ModelAndView
            mv.addObject("item", item);
        } catch (IdNaoEncontrado e) {
            throw new RuntimeException("ID do item não encontrado", e);
        }
        return mv;
    }


}
