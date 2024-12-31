package com.api.estoque.api_crud.Entity.Produto;

public interface ProdutoProjection {
    Long getProdutoId();
    String getNomeProduto();
    String getDescricaoProduto();
    Double getPrecoProduto();
    Long getCategoriaId();
    String getNomeCategoria();
    Long getItemId();
    String getNomeItem();
    Integer getQuantidadeItem();
    Integer getQuantidadeProduto();
}
