package com.api.estoque.api_crud.Service.Item;

import com.api.estoque.api_crud.DTO.Item.ItemRequestDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
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

    //Função para retornar os itens que estão esgotados
    public List<ItemResponseDTO> buscarItensEsgotagos() {
        List<ItemEntity> lItem = itemRepository.buscarItemEsgotados();
        List<ItemResponseDTO> lItemDTO = new ArrayList<>();
        for (ItemEntity i : lItem) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO(i.getId(), i.getNome());
            lItemDTO.add(itemResponseDTO);
        }
        return lItemDTO;
    }

    // Função para deletar um item no inventário
    public void deletarItem(Long id) throws IdNaoEncontrado {
        Optional<ItemEntity> itemOpt = itemRepository.findById(id);
        if (itemOpt.isEmpty()) {
            throw new IdNaoEncontrado("Item com ID " + id + " não foi encontrado.");
        }
        // Deleta o item se ele existir
        itemRepository.delete(itemOpt.get());
    }


}
