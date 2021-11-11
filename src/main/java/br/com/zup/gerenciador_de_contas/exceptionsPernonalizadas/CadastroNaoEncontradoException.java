package br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas;

public class CadastroNaoEncontradoException extends RuntimeException{
    public CadastroNaoEncontradoException(String message) {
        super(message);
    }
}
