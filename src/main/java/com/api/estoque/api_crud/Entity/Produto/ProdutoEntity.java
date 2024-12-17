package com.api.estoque.api_crud.Entity.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table( name = "table_produtos" )
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_produto", nullable = false )
    private Long id;
    @Column( name = "nome_produto", nullable = false )
    private String nomeProduto;
    @Column( name = "preco_produto", nullable = false )
    private Double precoProduto;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn( name = "id_produto" ),
            inverseJoinColumns = @JoinColumn( name = "id_categoria" )
    )
    private Set<CategoriaEntity> categoria;

}
