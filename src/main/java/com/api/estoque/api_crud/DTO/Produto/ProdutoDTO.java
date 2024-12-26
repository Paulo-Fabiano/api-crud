package com.api.estoque.api_crud.DTO.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @Lob
    @Column( name = "imagem_produto")
    private byte[] imagemProduto;
    @JsonProperty("nomeProduto")
    private String nomeProduto;
    @JsonProperty("descricaoProduto")
    private String descricaoProduto;
    @JsonProperty("precoProduto")
    private Double precoProduto;
    @JsonProperty("produtoCategoria")
    private List<Long> produtoCategoria = new ArrayList<>();
    @JsonProperty("produtoItens")
    private List<Long> produtoItens = new ArrayList<>();

}
