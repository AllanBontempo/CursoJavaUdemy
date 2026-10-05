package io.github.allanbontempo.bontempostore.produtos.service;

import io.github.allanbontempo.bontempostore.produtos.controller.dto.ProdutoDTO;
import io.github.allanbontempo.bontempostore.produtos.mappers.ProdutoMapper;
import io.github.allanbontempo.bontempostore.produtos.model.Produto;
import io.github.allanbontempo.bontempostore.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public Produto salvar(ProdutoDTO produto) {
        return produtoRepository.save(produtoMapper.toProduto(produto));
    }

    public Optional<Produto> obterPorCodigo(Long codigo) {
        return produtoRepository.findById(codigo);
    }



}
