package com.api.estoque.api_crud.Service.Produto;

import com.api.estoque.api_crud.DTO.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseProdutoDTO;
import com.api.estoque.api_crud.DTO.Produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.DTO.Produto.ProdutoResponseDTO;
import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoEntity;
import com.api.estoque.api_crud.Entity.Produto.ProdutoProjection;
import com.api.estoque.api_crud.Entity.ProdutoItemEntity.ProdutoItemEntity;
import com.api.estoque.api_crud.Repository.Categoria.CategoriaRepository;
import com.api.estoque.api_crud.Repository.ItemRepository;
import com.api.estoque.api_crud.Repository.Produto.ProdutoRepository;
import com.api.estoque.api_crud.Repository.ProdutoItem.ProdutoItemRepository;
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

    @Autowired
    private ProdutoItemRepository produtoItemRepository;

    // Função que adicionar um produto
    public ProdutoEntity adicionarProduto(ProdutoRequestDTO produtoDTO) {

        // Criar um objeto com os atributos nome, descrição, preço e quantidade
        ProdutoEntity produto = new ProdutoEntity(
                produtoDTO.getNomeProduto(),
                produtoDTO.getDescricaoProduto(),
                produtoDTO.getPrecoProduto(),
                produtoDTO.getQuantidadeProduto()
        );

        // Buscar as categorias e associar ao produto
        List<Long> listaLongCategorias = produtoDTO.getProdutoCategoria();
        List<CategoriaEntity> listaCategorias = new ArrayList<>();
        for (Long l : listaLongCategorias) {
            Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findById(l);
            if (!categoriaOpt.isPresent()) {
                throw new RuntimeException("Erro no For ao verificar");
            }
            listaCategorias.add(categoriaOpt.get());
        }
        produto.setProdutoCategoria(listaCategorias); // Setar a lista de categorias em Produto

        // Salvar o produto para obter o Id
        produto = produtoRepository.save(produto);

        for(Map.Entry<Long, Integer> i : produtoDTO.getProdutoItens().entrySet()) {
            ProdutoItemEntity produtoItemEntity = new ProdutoItemEntity();
            Optional<ItemEntity> itemOpt = itemRepository.findById(i.getKey());

            if (!itemOpt.isPresent()) {
                throw new RuntimeException("Id não encontrado");
            }
            produtoItemEntity.setProduto(produto);
            produtoItemEntity.setItem(itemOpt.get());
            produtoItemEntity.setQuantidadeItens(i.getValue());

            produtoItemEntity = produtoItemRepository.save(produtoItemEntity);

        }

        System.out.print("Produto Salvo!");
        return produto;

    }

    // Função que busca os produtos
    public List<ProdutoResponseDTO> buscarProdutos() {
        List<ProdutoProjection> resultados = produtoRepository.buscarListaProdutos();

        Map<Long, ProdutoResponseDTO> produtoMap = new HashMap<>();

        for (ProdutoProjection linha : resultados) {
            // Extrai dados da linha
            Long produtoId = linha.getProdutoId();
            String nomeProduto = linha.getNomeProduto();
            String descricaoProduto = linha.getDescricaoProduto();
            Double precoProduto = linha.getPrecoProduto();
            Integer quantidadeProduto = linha.getQuantidadeProduto();

            // Verifica se o produto já existe no mapa
            ProdutoResponseDTO produto = produtoMap.computeIfAbsent(produtoId, id -> {
                ProdutoResponseDTO p = new ProdutoResponseDTO();
                p.setId(produtoId);
                p.setNome(nomeProduto);
                p.setDescricao(descricaoProduto);
                p.setPreco(precoProduto);
                p.setQuantidade(quantidadeProduto);
                p.setCategorias(new ArrayList<>());
                p.setItens(new ArrayList<>());
                return p;
            });

            // Adiciona categoria, se existir
            if (linha.getCategoriaId() != null) {
                produto.getCategorias().add(new CategoriaResponseDTO(linha.getCategoriaId(), linha.getNomeCategoria()));
            }

            // Adiciona item, se existir
            if (linha.getItemId() != null) {
                produto.getItens().add(new ItemResponseDTO(linha.getItemId(), linha.getNomeItem(), linha.getQuantidadeItem()));
            }
        }

        return new ArrayList<>(produtoMap.values());
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
