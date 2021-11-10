package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;

import java.time.LocalDate;

public class ContaDTO {
    private String nome;
    private double valor;
    private Tipo tipo;
    private Status status;
    private LocalDate dataDeVencimento;

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


}
