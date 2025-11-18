package br.com.marketplace.models.dto;

import br.com.marketplace.models.ClientePJ;

public record   ClientePjResponse(String nome, String cnpj) {
    public ClientePjResponse(ClientePJ clientePJ) {
        this(clientePJ.getNome(), clientePJ.getCnpj());
    }
}
