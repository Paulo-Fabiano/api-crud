package com.api.estoque.api_crud.Service.Item;

import com.api.estoque.api_crud.DTO.Item.ItemRequestDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Função para adicionar itens no inventário
    public ItemResponseDTO adicionarItem(ItemRequestDTO dto) {
        ItemEntity item = new ItemEntity(dto.getNomeItem(), dto.getPrecoUnitario(), dto.getQuantidadeItem(), dto.getDataCompra());
        return itemRepository.save(item).tranformandoEmDTO();
    }

    // Função para retornar a lista de itens do inventário
    public List<ItemResponseDTO> buscarItens() {
        List<ItemEntity> lItem = itemRepository.findAll();
        List<ItemResponseDTO> lItemDTO = new ArrayList<>();
        for(ItemEntity i : lItem) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO(i.getId(), i.getNome(), i.getPreco(), i.getQuantidade(), i.getDataCompra());
            lItemDTO.add(itemResponseDTO);
        }
        return lItemDTO;
    }

    /*
     Corrigir essa função posteriormente
     */
    public void deletarItem(Long id) {
        Optional<ItemEntity> itemOpt = itemRepository.findById(id);
        if (itemOpt.isPresent()) {
            ItemEntity itemEntityExiste = itemOpt.get();
            itemRepository.delete(itemEntityExiste);
        }
    }

}
