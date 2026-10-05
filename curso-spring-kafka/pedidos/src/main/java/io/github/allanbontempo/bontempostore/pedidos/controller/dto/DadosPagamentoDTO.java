package io.github.allanbontempo.bontempostore.pedidos.controller.dto;

import io.github.allanbontempo.bontempostore.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados,
        TipoPagamento tipoPagamento
) {
}
