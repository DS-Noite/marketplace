package br.com.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "CLIENTE_PJ")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientePJ extends Cliente {

    private String cnpj;
}
