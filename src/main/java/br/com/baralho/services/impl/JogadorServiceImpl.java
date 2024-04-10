package br.com.baralho.services.impl;

import br.com.baralho.exception.BadRequestException;
import br.com.baralho.model.Jogador;
import br.com.baralho.repository.JogadorRepository;
import br.com.baralho.responses.ApiResponse;
import br.com.baralho.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;


    @Override
    public Jogador addJogador(Jogador jogador) {
        if (jogador.getNome() == null){
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "O nome de usuário já está em uso");
            throw new BadRequestException(apiResponse);
        }
        return jogadorRepository.save(jogador);
    }

    @Override
    public ApiResponse deleteJogador(UUID id) {
        if (!jogadorRepository.existsById(id)){
            ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Não foi possivel deletar jogador.");
            throw new BadRequestException(apiResponse);
        } else {
            jogadorRepository.deleteById(id);
        }

        return null;
    }

    @Override
    public List<Jogador> getAllJogadores() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> getJogadorById(UUID id) {

        if (!jogadorRepository.existsById(id)){
            ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Jogador Não deletado");
            throw new BadRequestException(apiResponse);
        } else {
            return jogadorRepository.findById(id);
        }
    }

}











