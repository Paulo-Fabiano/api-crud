package com.api.estoque.api_crud.Entity.Categoria;

import com.api.estoque.api_crud.DTO.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table( name = "table_categorias" )
@NoArgsConstructor
@Getter
public class CategoriaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", nullable = false )
    private Long id;
    @Column( name = "nome_categoria", nullable = false )
    private String nomeCategoria;

    // Criando o relacionamento com a entidade produtos
    @ManyToMany( mappedBy = "categoria" )
    private Set<ProdutoEntity> produtos;

    // Construtor padrão
    public CategoriaEntity(String nome) {
        this.nomeCategoria = nome;
    }

    // Tranformando em DTO Response
    public CategoriaResponseDTO tranformandoEmDTO() {
        return new CategoriaResponseDTO(getId(), getNomeCategoria());
    }

}
