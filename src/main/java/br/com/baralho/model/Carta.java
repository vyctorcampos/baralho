package br.com.baralho.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Carta {
    private UUID id;
    private String value;
    private String code;
    private String suit;
}
