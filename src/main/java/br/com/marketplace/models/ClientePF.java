package br.com.marketplace.models;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "CLIENTE_PF")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ClientePF extends Cliente {
    private String cpf;
}
