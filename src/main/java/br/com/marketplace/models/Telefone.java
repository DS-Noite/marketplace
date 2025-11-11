package br.com.marketplace.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Telefone {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    private String telefone;
}
