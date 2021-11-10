package br.com.zup.gerenciador_de_contas.contas;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
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

    public List<Conta> exibirContasCadastradas(){
        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }


}
