package com.api.estoque.api_crud.Controller;

import com.api.estoque.api_crud.Entity.Cliente;
import com.api.estoque.api_crud.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/api/adicionar")
    public ResponseEntity<Cliente> criarCliente(@ModelAttribute Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.criarCliente(cliente));
    }

    @GetMapping
    public ModelAndView viewCliente() {
        List<Cliente> clientes = clienteService.listarClientes();
        ModelAndView mv = new ModelAndView("/cliente/cliente");
        mv.addObject("clientes", clientes);
        return mv;
    }

    @DeleteMapping("/cliente")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

}
