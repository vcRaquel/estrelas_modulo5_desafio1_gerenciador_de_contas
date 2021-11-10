package br.com.zup.gerenciador_de_contas.contas;

import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta(@RequestBody ContaDTO contaDTO){
        Conta conta = modelMapper.map(contaDTO, Conta.class);

        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.salvarConta(conta), ContaSaidaDTO.class);
        return contaSaidaDTO;
    }


}
