package br.com.baralho.controllers.partida;

import br.com.baralho.model.Deck;
import br.com.baralho.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @GetMapping(value = "/decks/comparar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Deck>> compararDecks() {
        List<Deck> decksMaiorValor = partidaService.compararDecks();
        return ResponseEntity.ok(decksMaiorValor);
    }
}
