package io.github.allanbontempo.bontempostore.pedidos.model;

import lombok.Data;
import io.github.allanbontempo.bontempostore.pedidos.model.enums.TipoPagamento;

@Data
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}
