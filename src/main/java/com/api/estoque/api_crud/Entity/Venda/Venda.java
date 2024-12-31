package com.api.estoque.api_crud.Entity.Venda;

import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "vendas" )
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "data_venda" )
    private LocalDate data_venda;
    @Column( name = "valor_venda" )
    private Double valor_venda;

}
