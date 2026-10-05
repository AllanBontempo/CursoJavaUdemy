package io.github.allanbontempo.bontempostore.produtos.mappers;

import io.github.allanbontempo.bontempostore.produtos.controller.dto.ProdutoDTO;
import io.github.allanbontempo.bontempostore.produtos.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toProduto(ProdutoDTO produtoDTO);

}
