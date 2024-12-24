package com.api.estoque.api_crud.DTO.Produto;

//import com.api.estoque.api_crud.Repository.ProdutoCategoriaRepository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProdutoRequestDTO {

    // Campos do DTO
    @JsonProperty( "image" )
    private byte[] imagemProduto;
    @JsonProperty( "name" )
    private String nomeProduto;
    @JsonProperty( "description")
    private String descricaoProduto;
    @JsonProperty( "itens" )
    private Map<Long, Long> itens; // ID do item -> quantidade
    @JsonProperty( "categories" )
    private Set<Long> categorias; // IDs das categorias
    @JsonProperty( "price" )
    private Double precoProduto;
    @JsonProperty( "stock" )
    private Integer estoqueProduto;

//    public ProdutoEntity transformandoEmProdutoEntity(
//            CategoriaRepository categoriaRepository,
//            ItemRepository itemRepository) {
//
//        // Converter categorias
//        Set<CategoriaEntity> categoriaEntities = new HashSet<>();
//        if (categorias != null && !categorias.isEmpty()) {
//            categoriaEntities = new HashSet<>(categoriaRepository.findAllById(categorias));
//        }
//
//        // Converter itens
//        Set<ProdutoItemEstoqueEntity> itensEstoque = new HashSet<>();
//        if (itens != null && !itens.isEmpty()) {
//            itens.forEach((itemId, quantidade) -> {
//                ItemEntity itemEntity = itemRepository.findById(itemId)
//                        .orElseThrow(() -> new IllegalArgumentException("Item não encontrado com ID: " + itemId));
//                ProdutoItemEstoqueEntity produtoItemEstoque = new ProdutoItemEstoqueEntity();
//                produtoItemEstoque.setItem(itemEntity);
//                produtoItemEstoque.setQuantidade(quantidade);
//                produtoItemEstoque.setProduto(null); // Será configurado ao persistir
//                itensEstoque.add(produtoItemEstoque);
//            });
//        }
//
//        // Criar e retornar a entidade do produto
//        return new ProdutoEntity(
//                imagemProduto,
//                nomeProduto,
//                descricaoProduto,
//                categoriaEntities,
//                precoProduto,
//                itensEstoque
//        );
//    }
}
