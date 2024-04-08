package br.com.baralho.exception;

import java.io.Serial;

public class ProfileException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public ProfileException(String message) {
        super(message);
    }
}
