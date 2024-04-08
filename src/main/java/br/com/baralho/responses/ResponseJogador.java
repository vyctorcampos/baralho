package br.com.baralho.responses;

import br.com.baralho.model.Jogador;
import lombok.Data;

import java.util.List;

@Data
public class ResponseJogador {

    private Jogador jogador;
    private List<Jogador> customers;
    private String errorsMsg;
    private String successMsg;
}
