package br.com.marketplace.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public abstract class Cliente extends Pessoa{

}
