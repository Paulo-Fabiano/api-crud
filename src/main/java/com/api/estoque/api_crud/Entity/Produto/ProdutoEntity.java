package com.api.estoque.api_crud.Entity.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.ProdutoItemEntity.ProdutoItemEntity;
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
    @Lob
    @Column( name = "imagem")
    private byte[] imagemProduto;
    @Column( name = "nome")
    private String nomeProduto;
    @Column( name = "descricao" )
    private String descricaoProduto;

    @Column( name = "preco_unitario" )
    private Double precoUnitario;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn( name = "produto_id" ),
            inverseJoinColumns = @JoinColumn( name = "categoria_id" )
    )
    @JsonManagedReference
    private List<CategoriaEntity> produtoCategoria = new ArrayList<>();


    @OneToMany( mappedBy = "produto", cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<ProdutoItemEntity> produtoItens = new ArrayList<>();

    @Column( name = "quantidade")
    private Integer quantidade_produto;

    public ProdutoEntity(String nomeProduto, String descricaoProduto, Double precoUnitario, Integer quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade_produto = quantidadeProduto;
    }
}
