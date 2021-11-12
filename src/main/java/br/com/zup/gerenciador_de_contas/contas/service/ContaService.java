package br.com.zup.gerenciador_de_contas.contas.service;

import br.com.zup.gerenciador_de_contas.contas.Conta;
import br.com.zup.gerenciador_de_contas.contas.ContaRepository;
import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;
import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.CadastroNaoEncontradoException;
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

    public List<Conta> exibirContasCadastradas(Status status, Tipo tipo, Double valor) {
        if (status != null){
            return contaRepository.findAllByStatus(status);
        }else if (tipo != null){
            return contaRepository.findAllByTipo(tipo);
        }else if (valor != null){
            return contaRepository.findAllByValor(valor);
        }

        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }

    public Conta retornarContaPorId(int id) {
        Optional<Conta> conta = contaRepository.findById(id);
        //e se não tiver o id?
        if(conta.isEmpty()){
            throw new CadastroNaoEncontradoException("Cadastro não encontrado");
        }
        return conta.get();
    }

    public Conta atualizarConta(int id) {
        Conta conta = retornarContaPorId(id);
        //e se o Status colocado pelo Put for diferente de Pago?
        if (conta.getStatus() != (Status.PAGO)) {
            conta.setDataDePagamento(LocalDateTime.now());
            conta.setStatus(Status.PAGO);
            contaRepository.save(conta);
            return conta;
        }
        throw new StatusInvalidoException("Status inválido para a requisição");
    }
}
