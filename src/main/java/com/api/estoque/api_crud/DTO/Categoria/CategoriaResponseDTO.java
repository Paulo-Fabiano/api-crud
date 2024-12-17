package com.api.estoque.api_crud.DTO.Categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoriaResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty( "name" )
    private String nome_categoria;

}
