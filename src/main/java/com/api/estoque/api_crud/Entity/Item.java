package com.api.estoque.api_crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb-item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "nome_item")
    private String nome;
    @Column(name = "quantidade_item")
    private int quantidade;
    @Column(name = "preco_item")
    private double preco;
    @Column(name = "data_compra")
    private LocalDate dataCompra = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;
}
