package com.api.estoque.api_crud.Repository;

import com.api.estoque.api_crud.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
