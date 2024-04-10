package br.com.baralho.services.impl;

import br.com.baralho.model.Deck;
import br.com.baralho.repository.DeckRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PartidaServiceImplTest {

    @Mock
    private DeckRepository deckRepository;

    @InjectMocks
    private PartidaServiceImpl partidaService;

    @Test
    public void testCompararDecks() {
        Deck deck1 = new Deck();
        deck1.setId("1");
        deck1.setValuePoints("100");

        Deck deck2 = new Deck();
        deck2.setId("2");
        deck2.setValuePoints("90");

        Deck deck3 = new Deck();
        deck3.setId("3");
        deck3.setValuePoints("100");

        Deck deck4 = new Deck();
        deck4.setId("4");
        deck4.setValuePoints("80");

        List<Deck> allDecks = Arrays.asList(deck1, deck2, deck3, deck4);

        when(deckRepository.findAll()).thenReturn(allDecks);

        List<Deck> result = partidaService.compararDecks();

        //verificação
        assertEquals(2, result.size(), "O número de decks com o maior valor está diferente do esperado.");
        assertEquals("100", result.get(0).getValuePoints(), "O valor do primeiro deck está diferente do esperado.");
        assertEquals("100", result.get(1).getValuePoints(), "O valor do segundo deck está diferente do esperado.");
    }
}
