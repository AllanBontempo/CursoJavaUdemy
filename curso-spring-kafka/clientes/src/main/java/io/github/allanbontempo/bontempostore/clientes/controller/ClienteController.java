package io.github.allanbontempo.bontempostore.clientes.controller;

import io.github.allanbontempo.bontempostore.clientes.controller.dto.ClienteDTO;
import io.github.allanbontempo.bontempostore.clientes.model.Cliente;
import io.github.allanbontempo.bontempostore.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO cliente) {
        Cliente clienteSalvo = clienteService.salvar(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Cliente> buscarPorCodigo(@RequestParam("codigo") Long codigo) {
        return clienteService.obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
