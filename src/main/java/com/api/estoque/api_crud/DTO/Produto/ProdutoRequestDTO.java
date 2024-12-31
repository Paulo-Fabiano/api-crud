package com.api.estoque.api_crud.DTO.Produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @Lob
    @Column( name = "imagem_produto")
    private byte[] imagemProduto;
    @JsonProperty("nomeProduto")
    private String nomeProduto;
    @JsonProperty("descricaoProduto")
    private String descricaoProduto;
    @JsonProperty("precoProduto")
    private Double precoProduto;
    @JsonProperty("stock")
    private int quantidadeProduto;
    @JsonProperty("produtoCategoria")
    private List<Long> produtoCategoria = new ArrayList<>();
    @JsonProperty("produtoItens")
    private Map<Long, Integer> produtoItens = new HashMap<>();

}
