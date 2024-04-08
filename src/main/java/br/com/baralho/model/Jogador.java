package br.com.baralho.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Jogador {
    private UUID id;
    private String nome;
}
