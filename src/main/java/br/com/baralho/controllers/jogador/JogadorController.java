package br.com.baralho.controllers.jogador;

import br.com.baralho.model.Jogador;
import br.com.baralho.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;


    @PostMapping
    public ResponseEntity<Jogador> addJogador(@RequestBody Jogador jogador) {
        Jogador newJogador = jogadorService.addJogador(jogador);

        return new ResponseEntity<>(newJogador, HttpStatus.CREATED);
    }

    @DeleteMapping("/{jogadorId}")
    public ResponseEntity<?> deleteJogador(@PathVariable(value = "jogadorId") UUID jogadorId) {
        jogadorService.deleteJogador(jogadorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listJogador() {
        List<Jogador> jogadores = jogadorService.getAllJogadores();
        return ResponseEntity.ok(jogadores);
    }


}
