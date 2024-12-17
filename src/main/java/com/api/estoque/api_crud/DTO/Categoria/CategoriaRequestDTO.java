package com.api.estoque.api_crud.DTO.Categoria;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoriaRequestDTO {

    @JsonProperty("name")
    private String nome;

    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public CategoriaEntity tranformaEmCategoria() {
        return new CategoriaEntity(nome);
    }

}
