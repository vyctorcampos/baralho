package br.com.baralho.responses;

import br.com.baralho.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseJogador {

    private UUID id;
    private String nome;
}
