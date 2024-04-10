package br.com.baralho.services.impl;

import br.com.baralho.exception.BadRequestException;
import br.com.baralho.model.Jogador;
import br.com.baralho.repository.JogadorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class JogadorServiceImplTest {

    @Mock
    private JogadorRepository jogadorRepository;

    @InjectMocks
    private JogadorServiceImpl jogadorService;

    @Test
    public void testAddJogador() {

        Jogador jogador = new Jogador();
        jogador.setNome("Teste");


        when(jogadorRepository.save(jogador)).thenReturn(jogador);


        Jogador result = jogadorService.addJogador(jogador);


        assertEquals("Teste", result.getNome(), "O nome do jogador está diferente do esperado.");
    }

    @Test
    public void testAddJogadorWithNullName() {
        Jogador jogador = new Jogador();
        jogador.setNome(null);

        assertThrows(BadRequestException.class, () -> {
            jogadorService.addJogador(jogador);
        });
    }
}
