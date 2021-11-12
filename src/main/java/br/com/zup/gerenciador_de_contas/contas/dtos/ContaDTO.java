package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaDTO {

    @NotNull
    @Size(min = 2, message = "Nome com quantidade de caracteres inválida")
    private String nome;

    @DecimalMin(value = "0.0", inclusive = false, message = "Valor abaixo do permitido")
    @Digits(integer = 10, fraction = 2, message = "Valor inválido")
    private double valor;

    @NotNull
    private Tipo tipo;

    @NotNull(message = "Data de vencimento inválida")
    //validar como a data é passada?
    private LocalDate dataDeVencimento;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;

    public ContaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }
}
