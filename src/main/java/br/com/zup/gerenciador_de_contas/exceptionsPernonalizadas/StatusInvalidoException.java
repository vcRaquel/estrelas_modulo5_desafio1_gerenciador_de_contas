package br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas;

public class StatusInvalidoException extends RuntimeException{
    public StatusInvalidoException(String message) {
        super(message);
    }
}
