package io.github.allanbontempo.bontempostore.pedidos.controller.mappers;

import io.github.allanbontempo.bontempostore.pedidos.controller.dto.ItemPedidoDTO;
import io.github.allanbontempo.bontempostore.pedidos.controller.dto.NovoPedidoDTO;
import io.github.allanbontempo.bontempostore.pedidos.model.ItemPedido;
import io.github.allanbontempo.bontempostore.pedidos.model.Pedido;
import io.github.allanbontempo.bontempostore.pedidos.model.enums.StatusPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "itensPedido", target = "itensPedido", qualifiedByName = "toListItemPedidos")
    Pedido toPedido(NovoPedidoDTO novoPedidoDTO);

    @Named("toListItemPedidos")
    default List<ItemPedido> toListItemPedidos(List<ItemPedidoDTO> itemPedidoDTOs) {
        return itemPedidoDTOs.stream()
                .map(ITEM_PEDIDO_MAPPER::toItemPedido)
                .toList();
    }


    @AfterMapping
    default void preencherPedido(@MappingTarget Pedido pedido) {
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDataPedido(LocalDateTime.now());

        var total = calcularTotalPedido(pedido);

        pedido.setTotal(total);

        pedido.getItensPedido().forEach(item -> item.setPedido(pedido));
    }

    private static BigDecimal calcularTotalPedido(Pedido pedido) {
        return pedido.getItensPedido().stream()
                .map(item -> item.getValorUnitario()
                    .multiply(BigDecimal.valueOf(item.getQuantidade()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
