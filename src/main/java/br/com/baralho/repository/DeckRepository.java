package br.com.baralho.repository;

import br.com.baralho.model.Deck;
import br.com.baralho.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeckRepository extends JpaRepository<Deck, String> {
}
