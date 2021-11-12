package br.com.zup.gerenciador_de_contas.config;

import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.CadastroNaoEncontradoException;
import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.StatusCadastradoException;
import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.StatusInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularNotValidExceptions(MethodArgumentNotValidException exception) {
        List<MensagemDeErro> mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage()));
        }
        return mensagens;
    }

    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularStatusInvalidoException(StatusInvalidoException exception){
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(CadastroNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularCadastroNaoEncontradoException(CadastroNaoEncontradoException exception){
        return new MensagemDeErro(exception.getMessage());
    }


    //HttpMessageNotReadableException
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)//bad request?
    public MensagemDeErro manipularHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        return new MensagemDeErro("informação inválida para a requisição");
    }

    //StatusCadastradoException
    @ExceptionHandler(StatusCadastradoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)//bad request?
    public MensagemDeErro manipularStatusCadastradoException(StatusCadastradoException exception){
        return new MensagemDeErro(exception.getMessage());
    }
}

