package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.Entity.Venda;
import com.api.estoque.api_crud.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public Venda registrarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

//    public void diminuirItemEstoque(List<Item> listaItem) {
//
//    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

}
