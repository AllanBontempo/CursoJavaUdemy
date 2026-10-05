package io.github.allanbontempo.bontempostore.pedidos.controller;

import io.github.allanbontempo.bontempostore.pedidos.controller.dto.NovoPedidoDTO;
import io.github.allanbontempo.bontempostore.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<Object> criarPedido(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        var pedido = pedidoService.criarPedido(novoPedidoDTO);
        return ResponseEntity.ok(pedido.getCodigo());
    }
}
