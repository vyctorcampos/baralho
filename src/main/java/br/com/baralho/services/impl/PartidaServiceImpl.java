package br.com.baralho.services.impl;

import br.com.baralho.model.Deck;
import br.com.baralho.repository.DeckRepository;
import br.com.baralho.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidaServiceImpl implements PartidaService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public List<Deck> compararDecks() {

        List<Deck> desks = deckRepository.findAll().stream()
                .sorted(Comparator.comparing(Deck::getValuePoints, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .limit(4)
                .collect(Collectors.toList());

        double maiorValorDescks = desks.stream()
                .mapToDouble(deck -> Double.parseDouble(deck.getValuePoints()))
                .max()
                .orElse(0.0);


        return desks.stream()
                .filter(deck -> Double.parseDouble(deck.getValuePoints()) == maiorValorDescks)
                .collect(Collectors.toList());
    }
}

