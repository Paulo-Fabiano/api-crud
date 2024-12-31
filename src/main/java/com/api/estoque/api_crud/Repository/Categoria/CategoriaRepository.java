package com.api.estoque.api_crud.Repository.Categoria;


import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long > {

}
