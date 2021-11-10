package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaSaidaDTO {
    private int id;
    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDateTime dataDeVencimento;
    private LocalDate dataDePagamento;
    private Status status;

    public ContaSaidaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDateTime dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDate getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDate dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
