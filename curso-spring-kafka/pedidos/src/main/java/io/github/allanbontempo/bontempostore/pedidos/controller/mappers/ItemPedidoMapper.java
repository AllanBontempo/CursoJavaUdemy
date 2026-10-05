package io.github.allanbontempo.bontempostore.pedidos.controller.mappers;

import io.github.allanbontempo.bontempostore.pedidos.controller.dto.ItemPedidoDTO;
import io.github.allanbontempo.bontempostore.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido toItemPedido(ItemPedidoDTO itemPedidoDTO);

}
