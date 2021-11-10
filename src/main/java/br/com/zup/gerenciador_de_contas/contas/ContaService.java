package br.com.zup.gerenciador_de_contas.contas;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        }else{
            conta.setStatus(Status.AGUARDANDO);
        }
        return contaRepository.save(conta);
    }
}
