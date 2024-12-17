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
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_venda;
    private Double valor_venda;
    private boolean venda_revista = false;
    private boolean venda_estoque = false;
//    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ItemEntity> itemEntities;

}
