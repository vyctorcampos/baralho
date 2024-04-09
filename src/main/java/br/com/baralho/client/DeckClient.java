package br.com.baralho.client;

import br.com.baralho.responses.DeckResponse;
import br.com.baralho.responses.WrapperCardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "DeckOfCards", url = "https://deckofcardsapi.com")
public interface DeckClient {

    @RequestMapping("/api/deck/new/")
    DeckResponse newDeck();

    @RequestMapping("/api/deck/{deck_id}/draw/?count=5")
    WrapperCardResponse drawCard(@PathVariable("deck_id") String deck_id);

}
