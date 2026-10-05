package io.github.allanbontempo.bontempostore.pedidos.service;

import io.github.allanbontempo.bontempostore.pedidos.controller.dto.NovoPedidoDTO;
import io.github.allanbontempo.bontempostore.pedidos.controller.mappers.PedidoMapper;
import io.github.allanbontempo.bontempostore.pedidos.repository.ItemPedidoRepository;
import io.github.allanbontempo.bontempostore.pedidos.repository.PedidoRepository;
import io.github.allanbontempo.bontempostore.pedidos.validator.PedidoValidator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import io.github.allanbontempo.bontempostore.pedidos.model.Pedido;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;
    private final PedidoMapper pedidoMapper;


    public Pedido criarPedido(NovoPedidoDTO novoPedidoDTO) {
        var pedido = pedidoMapper.toPedido(novoPedidoDTO);

        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItensPedido());
        return pedido;
    }
}
