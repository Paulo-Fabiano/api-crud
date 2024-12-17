package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
import com.api.estoque.api_crud.Service.Item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueControllerAntiga {

//    @Autowired
//    private ItemService itemService;
//
//    @GetMapping
//    public ModelAndView viewEstoque() {
//        List<ItemEntity> listaItens = itemService.buscarTodosItens();
//        ModelAndView mv = new ModelAndView("estoque/estoque");
//        mv.addObject("itens", listaItens);
//        return mv;
//    }
//
//    @GetMapping("/cadastrar")
//    public ModelAndView viewAdicionar() {
//        ModelAndView mv = new ModelAndView("estoque/adicionar");
//        return mv;
//    }
//
//    @GetMapping("/atualizar/{id}")
//    public ModelAndView viewAtualizar(@PathVariable Long id) {
//        ModelAndView mv = new ModelAndView("estoque/atualizar");
//        try {
//            // Busca o item pelo ID
//            ItemEntity itemEntity = itemService.buscarItemPorId(id);
//            // Adiciona o item ao ModelAndView
//            mv.addObject("item", itemEntity);
//        } catch (IdNaoEncontrado e) {
//            throw new RuntimeException("ID do item não encontrado", e);
//        }
//        return mv;
//    }


}
