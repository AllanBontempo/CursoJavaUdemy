package io.github.allanbontempo.bontempostore.pedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.github.allanbontempo.bontempostore.pedidos.model.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codigo_cliente", nullable = false)
    private Long codigoCliente;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "chave_pagamento")
    private String chavePagamento;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "total", precision = 16, scale = 2)
    private BigDecimal total;

    @Column(name = "codigo_rastreio")
    private String codigoRastreio;

    @Column(name = "url_nf")
    private String urlNotaFiscal;

    @Transient
    private DadosPagamento dadosPagamento;

    @OneToMany(mappedBy = "pedido")
    List<ItemPedido> itensPedido;
}
