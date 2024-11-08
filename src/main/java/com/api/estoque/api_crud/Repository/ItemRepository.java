package com.api.estoque.api_crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.estoque.api_crud.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Quando estendemos o JpaReposirory é necessário especificar dois tipos genéricos.
     * O tipo da entidade e o tipo da chave primária desse objeto.
     */

}
