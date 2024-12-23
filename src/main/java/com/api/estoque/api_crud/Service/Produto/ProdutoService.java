package com.api.estoque.api_crud.Service.Produto;

import com.api.estoque.api_crud.DTO.Produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity.ProdutoItemEstoqueEntity;
import com.api.estoque.api_crud.Repository.Categoria.CategoriaRepository;
import com.api.estoque.api_crud.Repository.ItemRepository;
import com.api.estoque.api_crud.Repository.Produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

//    // Função para criar um produto
//    @Transactional
//    public ProdutoEntity adicionarProduto(ProdutoEntity produtoEntity, Map<Long, Integer> itemComQuantidade, Set<Long> idsCategorias) {
//        // Criar um conjunto para as associações da tabela intermediária
//        Set<ProdutoItemEstoqueEntity> produtoItemEstoques = new HashSet<>();
//
//        // Processar os itens associados
//        for (Map.Entry<Long, Integer> entry : itemComQuantidade.entrySet()) {
//            Long itemId = entry.getKey();
//            Integer quantidadeUtilizada = entry.getValue();
//
//            // Buscar o item no banco
//            ItemEntity item = itemRepository.findById(itemId)
//                    .orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + itemId));
//
//            // Verificar se há estoque suficiente
//            if (item.getQuantidade() < quantidadeUtilizada) {
//                throw new IllegalArgumentException("Estoque insuficiente para o item: " + item.getNome());
//            }
//
//            // Atualizar o estoque
//            item.setQuantidade(item.getQuantidade() - quantidadeUtilizada);
//
//            // Criar a entidade intermediária
//            ProdutoItemEstoqueEntity produtoItemEstoque = new ProdutoItemEstoqueEntity();
//            produtoItemEstoque.setProduto(produtoEntity);
//            produtoItemEstoque.setItemEstoque(item);
//            produtoItemEstoque.setQuantidadeUtilizada(quantidadeUtilizada);
//
//            // Adicionar ao conjunto
//            produtoItemEstoques.add(produtoItemEstoque);
//        }
//
//        // Associar os itens ao produto
//        produtoEntity.setItensEstoque(produtoItemEstoques);
//
//        // Buscar categorias no banco e converter para Set
//        Set<CategoriaEntity> categorias = new HashSet<>(categoriaRepository.findAllById(idsCategorias));
//        if (categorias.isEmpty() || categorias.size() != idsCategorias.size()) {
//            throw new IllegalArgumentException("Uma ou mais categorias não foram encontradas.");
//        }
//
//        // Associar as categorias ao produto
//        produtoEntity.setCategoria(categorias);
//
//        // Salvar o produto no banco de dados
//        return produtoRepository.save(produtoEntity);
//    }


    public ProdutoEntity adicionarProduto(ProdutoRequestDTO produtoRequestDTO) {
        ProdutoEntity produtoEntity = produtoRequestDTO.transformandoEmProdutoEntity(categoriaRepository, itemRepository);
        return produtoRepository.save(produtoEntity);
    }

}
