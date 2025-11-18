package br.com.marketplace.models.dto;

import br.com.marketplace.models.Endereco;
import br.com.marketplace.models.Telefone;

import java.util.List;

public record ClientePfRequest(String nome, String cpf, List<Telefone> telefone, Endereco endereco){
}
