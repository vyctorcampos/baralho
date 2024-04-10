package br.com.baralho.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaResponse {
    private UUID jogadores;
    private DeckResponse resultado;
}
