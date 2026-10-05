package io.github.allanbontempo.bontempostore.produtos.controller;

import io.github.allanbontempo.bontempostore.produtos.controller.dto.ProdutoDTO;
import io.github.allanbontempo.bontempostore.produtos.model.Produto;
import io.github.allanbontempo.bontempostore.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody ProdutoDTO produto) {
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.ok(produtoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> obterDados(@PathVariable("codigo") Long id){
        return produtoService.obterPorCodigo(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
