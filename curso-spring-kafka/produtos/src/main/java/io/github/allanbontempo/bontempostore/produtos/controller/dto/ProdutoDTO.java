package io.github.allanbontempo.bontempostore.produtos.controller.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
        String nome,
        BigDecimal valorUnitario
) {
}
