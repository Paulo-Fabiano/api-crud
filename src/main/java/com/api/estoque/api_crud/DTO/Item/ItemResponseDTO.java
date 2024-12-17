package com.api.estoque.api_crud.DTO.Item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    @JsonProperty( "id" )
    private Long id;
    @JsonProperty( "name" )
    private String nomeItem;
    @JsonProperty( "price" )
    private Double precoUnitario;
    @JsonProperty( "quantity" )
    private Integer quantidadeItem;
    @JsonProperty( "purchaseDate" )
    private String dataCompra;

}
