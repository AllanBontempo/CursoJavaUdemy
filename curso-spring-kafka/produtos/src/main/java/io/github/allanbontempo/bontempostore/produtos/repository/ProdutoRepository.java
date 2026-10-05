package io.github.allanbontempo.bontempostore.produtos.repository;

import io.github.allanbontempo.bontempostore.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
