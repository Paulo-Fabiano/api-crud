package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Item;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
import com.api.estoque.api_crud.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /*
        Controller que cria itens
     */

    @PostMapping("item")
    public String criarItem(Item item, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        try {
            itemService.salvarItem(item);
            redirectAttributes.addFlashAttribute("mensagem", "Item criado com sucesso");
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao criar Item: " + e.getMessage());
        }
        return "redirect:/estoque/cadastrar";
    }

    @GetMapping("item")
    public ResponseEntity<List<Item>> buscarTodosItens() {
        List<Item> itens = itemService.buscarTodosItens();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("item/{id}")
    public ResponseEntity<Item> buscarItemPorId(@PathVariable Long id) throws IdNaoEncontrado {
        return ResponseEntity.ok().body(itemService.buscarItemPorId(id));
    }

    /*
        Controller que atualiza os itens
     */

    @PostMapping("item/{id}")
    public ModelAndView atualizarItem(@PathVariable Long id, @ModelAttribute Item item) {
        ModelAndView mv = new ModelAndView();
        try {
            itemService.atualizarItem(id, item);

            mv.setViewName("estoque/atualizar");
            mv.addObject("mensagem", "Item atualizado com sucesso");
        }
        catch (Exception e) {
            mv.setViewName("estoque/atualizar");
            mv.addObject("mensagemErro", "Erro ao atualizar o item: " + e.getMessage());
        }
        return mv;
    }

    /*
        Controller que deleta itens
        Por enquanto vou ter que definir como POST, devido a um problema no HTML, após terminar o projeto irei corrigir
     */
    @PostMapping("item/deletar/{id}")
    public String delatarItem(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            itemService.deletarItem(id);
            mv.addObject("mensagem", "Item excluido com sucesso");

        }
        catch (Exception e) {
            mv.addObject("mensagemErro", "Erro ao excluir o item: " + e.getMessage());
        }
        return "redirect:/estoque";
    }

}
