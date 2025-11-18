package br.com.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Contrata {
    @Id
    @Column(name = "contrata_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;

    @Column(name = "data_hora")
    private LocalDateTime HorarioAgendamento;

    private String formaPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_Profissional")
    private Profissional profissional;
    @ManyToOne
    private Servico servico;

    @OneToOne
    @JoinColumn(name = "Id_Avalia")
    private Avalia avaliacao;

    public enum Status{
        PENDENTE,
        ANDAMENTO,
        CONCLUIDO,
        CANCELADO,
    }
}
