package io.github.allanbontempo.bontempostore.pedidos.repository;

import io.github.allanbontempo.bontempostore.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
