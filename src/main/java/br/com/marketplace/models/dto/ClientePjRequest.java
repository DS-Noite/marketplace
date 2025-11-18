package br.com.marketplace.models.dto;

import br.com.marketplace.models.Endereco;
import br.com.marketplace.models.Telefone;

import java.util.List;

public record ClientePjRequest (String nome, String cnpj, List<Telefone> telefone, Endereco endereco){
}
