package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.enuns.Status;

public class ContaSaidaResumoDTO {
    private int id;
    private String nome;
    private double valor;
    private Status status;

    public ContaSaidaResumoDTO() {
    }

    public ContaSaidaResumoDTO(int id, String nome, double valor, Status status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
