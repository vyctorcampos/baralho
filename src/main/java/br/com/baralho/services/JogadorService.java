package br.com.baralho.services;

import br.com.baralho.model.Jogador;
import br.com.baralho.responses.ApiResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorService {

    Jogador addJogador(Jogador jogador);

    ApiResponse deleteJogador(UUID id);

    List<Jogador> getAllJogadores();

    Optional<Jogador> getJogadorById(UUID id);
}
