package com.api.estoque.api_crud.Repository.Produto;

import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
