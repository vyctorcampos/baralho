package br.com.baralho.controllers.jogador;

import br.com.baralho.client.DeckClient;
import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import br.com.baralho.repository.JogadorRepository;
import br.com.baralho.responses.ApiResponse;
import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;
import br.com.baralho.services.DecKService;
import br.com.baralho.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private DeckClient deckClient;

    @Autowired
    private DecKService decKService;
    @Autowired
    private JogadorRepository jogadorRepository;


    @PostMapping
    public ResponseEntity<Jogador> addJogador(@RequestBody Jogador jogador) {
        Jogador newJogador = jogadorService.addJogador(jogador);

        return new ResponseEntity< >(newJogador, HttpStatus.CREATED);
    }

    @DeleteMapping("/{jogadorId}")
    public ResponseEntity<ApiResponse> deleteJogador(@PathVariable(value = "jogadorId") UUID jogadorId) {
        ApiResponse apiResponse = jogadorService.deleteJogador(jogadorId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listJogador() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return ResponseEntity.ok(jogadores);
    }


}
