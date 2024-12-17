package com.api.estoque.api_crud.Repository.Categoria;


import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long > {

}
