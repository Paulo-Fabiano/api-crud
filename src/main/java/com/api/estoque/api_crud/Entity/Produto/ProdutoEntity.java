package com.api.estoque.api_crud.Entity.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity.ProdutoItemEstoqueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
    @Lob
    @Column( name = "imagem_produto")
    private byte[] imagemProduto;
    @Column( name = "nome_produto", nullable = false )
    private String nomeProduto;
    @Column( name = "descricao_produto" )
    private String descricaoProduto;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn( name = "id_produto" ),
            inverseJoinColumns = @JoinColumn( name = "id_categoria" )
    )

    private Set<CategoriaEntity> categoria;

    @Column( name = "preco_produto", nullable = false )
    private Double precoProduto;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoItemEstoqueEntity> itensEstoque = new HashSet<>();

}
