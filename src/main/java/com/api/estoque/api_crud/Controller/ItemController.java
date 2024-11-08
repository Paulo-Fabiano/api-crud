package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Item;
import com.api.estoque.api_crud.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ItemController {

    private ItemService itemService;

    @GetMapping("/")
    public ModelAndView teste() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping("item")
    public ResponseEntity<Item> salvarItem(Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.salvarItem(item));
    }

    @GetMapping("item")
    public ResponseEntity<List<Item>> buscarTodosItens() {
        List<Item> itens = itemService.buscarTodosItens();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("item/{id}")
    public ResponseEntity<Item> buscarItemPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemService.buscarItemPorId(id));
    }

    @PutMapping("item/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.atualizarItem(id, item));
    }

    @DeleteMapping("item/{id}")
    public void delatarItem(@PathVariable Long id) {
        itemService.deletarItem(id);
    }
}
