package com.api.estoque.api_crud.Entity.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Table( name = "produtos" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id")
    private Long id;
//    @Lob
//    @Column( name = "imagem_produto")
//    private byte[] imagemProduto;
    @Column( name = "nome_produto")
    private String nomeProduto;
    @Column( name = "descricao_produto" )
    private String descricaoProduto;

    @Column( name = "preco_produto" )
    private Double precoProduto;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn( name = "produto_id" ),
            inverseJoinColumns = @JoinColumn( name = "categoria_id" )
    )
    @JsonManagedReference
    private List<CategoriaEntity> produtoCategoria = new ArrayList<>();

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "produto_item",
            joinColumns = @JoinColumn( name = "produto_id" ),
            inverseJoinColumns = @JoinColumn( name = "item_id" )
    )
    @JsonManagedReference
    private List<ItemEntity> produtoItens = new ArrayList<>();




    public ProdutoEntity(String nomeProduto, String descricaoProduto, Double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
    }
}
