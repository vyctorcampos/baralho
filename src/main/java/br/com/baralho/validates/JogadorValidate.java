package br.com.baralho.validates;

import br.com.baralho.model.Jogador;

import java.util.HashSet;
import java.util.Set;

public class JogadorValidate {


    public static String createValidate(Jogador jogador) {
        String msg = "";
        Set<String> errorMsgs = validateJogador(jogador);

        if (!errorMsgs.isEmpty()) {
            for (String field : errorMsgs) {
                if (msg.isEmpty()) {
                    msg = "Informar corretamente os campos: " + field;
                } else {
                    msg += ", " + field;
                }
            }
        }

        return msg;
    }

    private static Set<String> validateJogador(Jogador jogador) {
        Set<String> errorMsgs = new HashSet<>();

        if (jogador == null) {
            errorMsgs.add("Nenhuma informação sobre o jogador foi informada");
        } else {
            if (jogador.getNome() == null || jogador.getNome().isEmpty()) {
                errorMsgs.add("Nome do jogador");
            }
        }

        return errorMsgs;
    }
}
