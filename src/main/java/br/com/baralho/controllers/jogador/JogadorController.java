package br.com.baralho.controllers.jogador;

import br.com.baralho.client.DeckClient;
import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
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
        return ResponseEntity.ok("Lista de jogadores.");
    }

    @PostMapping("/{jogadorId}/deck/new")
    public ResponseEntity<?> newDeck(@PathVariable(value = "jogadorId") UUID jogadorId) {
        Optional<Jogador> jogador = jogadorService.getJogadorById(jogadorId);
        DeckResponse deckResponse = deckClient.newDeck();

        Deck deck = decKService.AddDeck(deckResponse, jogador);
        return ResponseEntity.ok(deck);


    }

    @PostMapping("/deck/{deck_id}/sort")
    public ResponseEntity<?> newDeck(@PathVariable String deck_id) {
        WrapperCardResponse deckResponse = deckClient.drawCard(deck_id);
        int valueDeck = decKService.ValuePointsDeck(deckResponse);
        return ResponseEntity.ok(valueDeck);
    }

}
