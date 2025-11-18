package br.com.marketplace.models.dto;

import br.com.marketplace.models.ClientePF;
import br.com.marketplace.models.Endereco;
import br.com.marketplace.models.Telefone;

import java.util.List;

public record ClientePfResponse(String nome, String cpf) {
    public ClientePfResponse(ClientePF clientePF) {
        this(clientePF.getNome(), clientePF.getCpf());
    }

}
