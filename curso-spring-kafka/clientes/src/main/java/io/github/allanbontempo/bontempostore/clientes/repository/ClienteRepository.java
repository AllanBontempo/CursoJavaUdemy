package io.github.allanbontempo.bontempostore.clientes.repository;

import io.github.allanbontempo.bontempostore.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
