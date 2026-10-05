package io.github.allanbontempo.bontempostore.produtos.controller.dto;

import java.math.BigDecimal;

public record NovoProdutoDTO(
        String nome,
        String descricao,
        BigDecimal valorUnitario
) {
}
