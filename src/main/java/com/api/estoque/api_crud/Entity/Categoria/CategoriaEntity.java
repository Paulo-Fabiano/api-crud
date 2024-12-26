package com.api.estoque.api_crud.Entity.Categoria;

import com.api.estoque.api_crud.DTO.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "categorias" )
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CategoriaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", nullable = false )
    private Long id;
    @Column( name = "nome_categoria", nullable = false )
    private String nomeCategoria;

    // Criando o relacionamento com a entidade produtos
    @JsonIgnore
    @ManyToMany( mappedBy = "produtoCategoria" )
    @JsonBackReference
    private List<ProdutoEntity> produtos = new ArrayList<>();

    // Construtor padrão
    public CategoriaEntity(String nome) {
        this.nomeCategoria = nome;
    }

    // Tranformando em DTO Response
    public CategoriaResponseDTO tranformandoEmDTO() {
        return new CategoriaResponseDTO(getId(), getNomeCategoria());
    }

}
