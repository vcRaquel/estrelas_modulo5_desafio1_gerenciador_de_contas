package br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas;

public class StatusCadastradoException extends RuntimeException{
    public StatusCadastradoException(String message) {
        super(message);
    }
}
