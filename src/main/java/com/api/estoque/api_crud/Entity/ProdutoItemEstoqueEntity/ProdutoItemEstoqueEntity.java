package com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity;

import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "table_produto_item_estoque_entity")
@Getter
@Setter
public class ProdutoItemEstoqueEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "id_item_estoque", nullable = false)
    private ItemEntity itemEstoque;

    @Column(name = "quantidade_utilizada", nullable = false)
    private Integer quantidadeUtilizada;

}
