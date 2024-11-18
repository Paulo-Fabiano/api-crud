package com.api.estoque.api_crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Item> produtos;
    private LocalDate data_venda;
    private Double valor_venda;
    private boolean venda_revista;
    private boolean venda_estoque;

}
