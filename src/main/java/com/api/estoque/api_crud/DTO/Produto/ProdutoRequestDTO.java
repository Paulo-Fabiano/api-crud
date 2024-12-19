package com.api.estoque.api_crud.DTO.Produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @JsonProperty( "image" )
    private byte[] imagemProduto;
    @JsonProperty( "name" )
    private String nomeProduto;
    @JsonProperty( "description" )
    private String descricaoProduto;
    @JsonProperty( "itens" )
    private Set<Long> itens;
    @JsonProperty( "category" )
    private Set<Long> categorias;
    @JsonProperty( "price" )
    private Double precoProduto;
    @JsonProperty( "quantity" )
    private Integer estoqueProduto;

}
