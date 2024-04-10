package br.com.baralho.controllers.deck;

import br.com.baralho.client.DeckClient;
import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;
import br.com.baralho.services.DecKService;
import br.com.baralho.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private DecKService decKService;

    @PostMapping("/{jogadorId}/deck/new")
    public ResponseEntity<?> newDeck(@PathVariable(value = "jogadorId") UUID jogadorId) {
        Optional<Jogador> jogador = jogadorService.getJogadorById(jogadorId);
        DeckResponse deckResponse = deckClient.newDeck();

        Deck deck = decKService.AddDeck(deckResponse, jogador);
        return ResponseEntity.ok(deck);


    }

    @PostMapping("/{deck_id}/sort")
    public ResponseEntity<?> newDeck(@PathVariable String deck_id) {
        WrapperCardResponse deckResponse = deckClient.drawCard(deck_id);
        int valueDeck = decKService.ValuePointsDeck(deckResponse);
        return ResponseEntity.ok(valueDeck);
    }
}
