package io.github.allanbontempo.bontempostore.clientes.service;

import io.github.allanbontempo.bontempostore.clientes.controller.dto.ClienteDTO;
import io.github.allanbontempo.bontempostore.clientes.mappers.ClienteMapper;
import io.github.allanbontempo.bontempostore.clientes.model.Cliente;
import io.github.allanbontempo.bontempostore.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public Cliente salvar(ClienteDTO cliente) {
        return clienteRepository.save(clienteMapper.toCliente(cliente));
    }

    public Optional<Cliente> obterPorCodigo(Long codigo) {
        return clienteRepository.findById(codigo);
    }
}
