package br.com.baralho.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeckResponse {

    private boolean success;
    private boolean shuffled;
    private String deck_id;

}
