package com.api.estoque.api_crud.Entity.Item;

import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity.ProdutoItemEstoqueEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_itens")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "nome_item" )
    private String nome;
    @Column( name = "preco_item" )
    private double preco;
    @Column( name = "quantidade_item" )
    private int quantidade;
    @Column( name = "data_compra" )
    private String dataCompra;

    public ItemEntity(String n, double p, int q, String dC) {
          this.nome = n;
          this.preco = p;
          this.quantidade = q;
          this.dataCompra = dC;
    }

    @ManyToMany(mappedBy = "produtoItens" )
    @JsonBackReference
    private List<ProdutoEntity> produtosItem = new ArrayList<>();

    // Tranformando em DTO Response
    public ItemResponseDTO tranformandoEmDTO() {
        return new ItemResponseDTO(getId(), getNome(), getPreco(), getQuantidade(), getDataCompra());
    }

}
