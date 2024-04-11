package br.com.baralho.services;

import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;

import java.util.Optional;

public interface DecKService {

    Deck AddDeck(DeckResponse deckResponse, Optional<Jogador> jogador);

    int ValuePointsDeck(WrapperCardResponse wrapperCardResponse);

    void deleteDeck(String id);
}
