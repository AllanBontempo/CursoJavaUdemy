package io.github.allanbontempo.bontempostore.clientes.controller.dto;

public record ClienteDTO(
        String nome,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String email,
        String telefone
) {
}
