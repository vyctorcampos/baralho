package br.com.baralho.model;

import lombok.Data;

import java.util.UUID;

@Data
public class DeckCarta {
    private UUID id;
    private UUID deck_id;
    private UUID cartas_id;
}
