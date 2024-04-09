package br.com.baralho.responses;

import lombok.Data;

import java.util.List;

@Data
public class WrapperCardResponse {
    private boolean success;
    private String deck_id;
    private List<CardResponse> cards;
}
