package io.github.allanbontempo.bontempostore.clientes.mappers;

import io.github.allanbontempo.bontempostore.clientes.controller.dto.ClienteDTO;
import io.github.allanbontempo.bontempostore.clientes.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente(ClienteDTO clienteDTO);


}
