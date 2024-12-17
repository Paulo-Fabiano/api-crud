package com.api.estoque.api_crud.DTO.Item;

import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemRequestDTO {

    @JsonProperty( "name" )
    private String nomeItem;
    @JsonProperty( "price" )
    private Double precoUnitario;
    @JsonProperty( "quantity" )
    private Integer quantidadeItem;
    @JsonProperty( "purchaseDate" )
    private String dataCompra;

    public ItemEntity tranformandoEmItem() {
        return new ItemEntity(nomeItem, precoUnitario, quantidadeItem, dataCompra);
    }

}
