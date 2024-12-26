package com.api.estoque.api_crud.Service.Produto;

import com.api.estoque.api_crud.DTO.Produto.ProdutoDTO;
import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.api.estoque.api_crud.Repository.Categoria.CategoriaRepository;
import com.api.estoque.api_crud.Repository.ItemRepository;
import com.api.estoque.api_crud.Repository.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Função que adicionar um produto
    public ProdutoEntity adicionarProduto(ProdutoDTO produtoDTO) {

        ProdutoEntity produto = new ProdutoEntity(
                produtoDTO.getNomeProduto(),
                produtoDTO.getDescricaoProduto(),
                produtoDTO.getPrecoProduto()
        );

        List<Long> listaLongCategorias = produtoDTO.getProdutoCategoria();
        List<CategoriaEntity> listaCategorias = new ArrayList<>();
        for (Long l : listaLongCategorias) {
            Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findById(l);
            if (!categoriaOpt.isPresent()) {
                throw new RuntimeException("Erro no For ao verificar");
            }
            listaCategorias.add(categoriaOpt.get());
        }
        produto.setProdutoCategoria(listaCategorias);

        List<Long> listaLongItens = produtoDTO.getProdutoItens();
        List<ItemEntity> listaItens = new ArrayList<>();
        for (Long i : listaLongItens) {
            Optional<ItemEntity> itemOpt = itemRepository.findById(i);
            if (!itemOpt.isPresent()) {
                throw new RuntimeException();
            }
            listaItens.add(itemOpt.get());
        }
        produto.setProdutoItens(listaItens);

        produto = produtoRepository.save(produto);
        System.out.print("Produto Salvo!");
        return produto;

    }

    // Função que busca os produtos
    public List<ProdutoEntity> buscarProdutos() {
        return produtoRepository.findAll();
    }

    // Função para remover um produto
    public void deletarProduto(Long id) {
        Optional<ProdutoEntity> produtoOpt = produtoRepository.findById(id);
        if (!produtoOpt.isPresent()) {
            throw new RuntimeException("Cliente com Id não encontrado");
        }
        produtoRepository.deleteById(id);
    }


}
