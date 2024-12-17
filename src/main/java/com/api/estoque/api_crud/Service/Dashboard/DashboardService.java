package com.api.estoque.api_crud.Service.Dashboard;

import com.api.estoque.api_crud.Entity.Venda.Venda;
import com.api.estoque.api_crud.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private VendaRepository vendaRepository;



}
