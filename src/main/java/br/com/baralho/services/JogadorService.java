package br.com.baralho.services;

import br.com.baralho.model.Jogador;
import br.com.baralho.responses.ResponseJogador;

public interface JogadorService {

    ResponseJogador createJogador(Jogador jogador);
}
