package br.com.baralho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DeckCarta {
    @Id
    private UUID id;
    private UUID deck_id;
    private UUID cartas_id;
}
