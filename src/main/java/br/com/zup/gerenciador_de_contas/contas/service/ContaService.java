package br.com.zup.gerenciador_de_contas.contas.service;

import br.com.zup.gerenciador_de_contas.contas.Conta;
import br.com.zup.gerenciador_de_contas.contas.ContaRepository;
import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.StatusInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {

        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return contaRepository.save(conta);
    }

    public List<Conta> exibirContasCadastradas() {
        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }

    public Conta retornarContaPorId(int id) {
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.get();
        //e se não tiver o id?
    }

    public Conta atualizarConta(int id) {
        Conta conta = retornarContaPorId(id);
        //e se o Status colocado pelo Put for diferente de Pago?
        if (conta.getStatus().equals(Status.PAGO)) {
            conta.setDataDePagamento(LocalDateTime.now());
            conta.setStatus(Status.PAGO);
            contaRepository.save(conta);
            return conta;
        }
        throw new StatusInvalidoException("Status inválido para a requisição");
    }
}
