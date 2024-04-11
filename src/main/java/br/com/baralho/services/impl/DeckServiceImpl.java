package br.com.baralho.services.impl;

import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import br.com.baralho.repository.DeckRepository;
import br.com.baralho.responses.CardResponse;
import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;
import br.com.baralho.services.DecKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceImpl implements DecKService {

    @Autowired
    private DeckRepository deckRepository;

    public Deck AddDeck(DeckResponse deckResponse, Optional<Jogador> jogador) {
        Deck deck = new Deck();
        jogador.ifPresent(deck::setJogador);
        deck.setId(deckResponse.getDeck_id());
        deck.setValuePoints("0");
        return deckRepository.save(deck);
    }

    @Override
    public void deleteDeck(String id) {
        Optional<Deck> deck = deckRepository.findById(id);
        deckRepository.delete(deck.get());
    }

    public int ValuePointsDeck(WrapperCardResponse wrapperCardResponse) {
        Optional<Deck> oldDeck = deckRepository.findById(wrapperCardResponse.getDeck_id());
        int cardsValueCount = 0;
        if (oldDeck.isPresent()) {
            Deck deck = oldDeck.get();
            List<CardResponse> cards = wrapperCardResponse.getCards();

            for (CardResponse cardResponse : cards) {
                System.out.println(cardResponse.getValue());

                switch (cardResponse.getValue()) {
                    case "ACE":
                        cardsValueCount += 1;
                        break;
                    case "KING":
                        cardsValueCount += 13;
                        break;
                    case "QUEEN":
                        cardsValueCount += 12;
                        break;
                    case "JACK":
                        cardsValueCount += 11;
                        break;
                    default:
                        cardsValueCount += Integer.parseInt(cardResponse.getValue());
                        break;
                }
            }
            deck.setValuePoints(String.valueOf(cardsValueCount));

            deckRepository.save(deck);
        }
        return cardsValueCount;
    }


}
