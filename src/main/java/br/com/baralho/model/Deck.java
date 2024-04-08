package br.com.baralho.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Deck {
    private UUID id;
    private UUID jogador_id;
    private String valuePoints;
}
