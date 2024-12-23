package com.api.estoque.api_crud.Entity.Produto;

import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.ProdutoItemEstoqueEntity.ProdutoItemEstoqueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "table_produtos" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_produto")
    private Long id;
    @Lob
    @Column( name = "imagem_produto")
    private byte[] imagemProduto;
    @Column( name = "nome_produto")
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

    @Column( name = "preco_produto" )
    private Double precoProduto;

    @ManyToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<ProdutoItemEstoqueEntity> itensEstoque = new HashSet<>();

    public ProdutoEntity(byte[] imagemProduto, String nomeProduto, String descricaoProduto, Set<CategoriaEntity> categoriaEntities, Double precoProduto, Set<ProdutoItemEstoqueEntity> itensEstoque) {
    }


}
