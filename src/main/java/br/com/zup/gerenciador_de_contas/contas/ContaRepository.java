package br.com.zup.gerenciador_de_contas.contas;

import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository <Conta, Integer>{
    List<Conta> findAllByStatus(Status status);
    List<Conta> findAllByTipo(Tipo tipo);

//    @Query(value = "SELECT * FROM contas WHERE VALOR BETWEEN :valor*0.9 AND :valor*1.2", nativeQuery = true)
    @Query(value = "SELECT * FROM contas WHERE VALOR BETWEEN :valor-10 AND :valor+10", nativeQuery = true)
    List<Conta>findAllByValor(Double valor);

}



