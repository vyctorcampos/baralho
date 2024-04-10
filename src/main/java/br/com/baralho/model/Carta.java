package br.com.baralho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data

public class Carta {
    @Id
    private UUID id;
    private String value;
    private String code;
    private String suit;
}
