package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.Entity.Item;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
import com.api.estoque.api_crud.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item salvarItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> buscarTodosItens() {
        return itemRepository.findAll();
    }

    public Item buscarItemPorId(Long id) throws IdNaoEncontrado {
        Optional<Item> itemOpt = itemRepository.findById(id);
        if (!itemOpt.isPresent()) {
            throw new IdNaoEncontrado("Erro!, ID: "+" não encontrado!");
        }
        return itemOpt.get();
    }

    /*
        Corrigir essa função depois
     */

    public Item atualizarItem(Long id, Item itemdto) {
        Optional<Item> itemOpt = itemRepository.findById(id);
        if (itemOpt.isPresent()) {
            Item item = itemOpt.get();
            item.setNome(itemdto.getNome());
            item.setQuantidade(itemdto.getQuantidade());
            item.setPreco(itemdto.getPreco());
            itemRepository.save(item);
            return item;
        }
        return itemdto;
    }

    public Item att(Item item) {
        Item itematt = new Item();
        itematt = item;
        return itematt;
    }

    /*
     Corrigir essa função posteriormente
     */
    public void deletarItem(Long id) {
        Optional<Item> itemOpt = itemRepository.findById(id);
        if (itemOpt.isPresent()) {
            Item itemExiste = itemOpt.get();
            itemRepository.delete(itemExiste);
        }
    }

}
