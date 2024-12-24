package com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity;

import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "produto_item_estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoItemEstoqueEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private ItemEntity itemEstoque;

    @Column(name = "quantidade_utilizada", nullable = false)
    private Integer quantidadeUtilizada;

    public void setItem(ItemEntity itemEntity) {
    }

    public void setQuantidade(Long quantidade) {
    }

}
