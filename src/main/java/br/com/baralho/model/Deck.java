package br.com.baralho.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="deck")
public class Deck {
    @Id
    private String id;

    @OneToOne
    private Jogador jogador;

    @Column(name = "value_points")
    private String valuePoints;

}
