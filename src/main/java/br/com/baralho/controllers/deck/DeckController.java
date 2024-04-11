package br.com.baralho.controllers.deck;

import br.com.baralho.client.DeckClient;
import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;
import br.com.baralho.services.DecKService;
import br.com.baralho.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private DeckClient deckClient;

    @Autowired
    private DecKService deckService;

    @PostMapping("/{jogadorId}/deck/new")
    public ResponseEntity<?> newDeck(@PathVariable(value = "jogadorId") UUID jogadorId) {
        Optional<Jogador> jogador = jogadorService.getJogadorById(jogadorId);
        DeckResponse deckResponse = deckClient.newDeck();

        Deck deck = deckService.AddDeck(deckResponse, jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(deck);
    }

    @PostMapping("/{deck_id}/sort")
    public ResponseEntity<?> newDeck(@PathVariable String deck_id) {
        WrapperCardResponse deckResponse = deckClient.drawCard(deck_id);
        int valueDeck = deckService.ValuePointsDeck(deckResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(valueDeck);
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<?> deleteDeck(@PathVariable(value = "deckId") String deckId) {
        deckService.deleteDeck(deckId);
        return ResponseEntity.noContent().build();
    }

}
