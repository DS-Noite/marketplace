package br.com.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "PESSOA") // A tabela não será criada, mas a anotação é necessária.
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public abstract class Pessoa {
    @Id
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.PERSIST)
    List<Telefone> telefones;
    @Embedded
    private Endereco endereco;

}
