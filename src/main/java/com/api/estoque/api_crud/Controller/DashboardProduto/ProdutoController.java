package com.api.estoque.api_crud.Controller.DashboardProduto;

import com.api.estoque.api_crud.DTO.Produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.api.estoque.api_crud.Service.Produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping( "/api/produtos" )
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
//
//    // Endppoint para adicionar produtos
//    @PostMapping( "/adicionar" )
//    public ResponseEntity<?> criarProduto(@RequestBody ProdutoEntity produtoEntity, Map<Long, Integer> itensComQuantidade, Set<Long> idsCategorias) {
//        return ResponseEntity.ok(produtoService.adicionarProduto(produtoEntity, itensComQuantidade, idsCategorias));
//    }
    @PostMapping("/adicionar")
    public ResponseEntity<?> criarProduto(@RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(produtoService.adicionarProduto(dto));
    }

    @GetMapping
    public ResponseEntity<?> buscarProdutos() {
        return ResponseEntity.ok("Criar função");
    }


}
