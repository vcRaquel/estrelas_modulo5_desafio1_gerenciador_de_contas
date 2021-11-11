package br.com.zup.gerenciador_de_contas.contas.controller;

import br.com.zup.gerenciador_de_contas.contas.Conta;
import br.com.zup.gerenciador_de_contas.contas.ContaService;
import br.com.zup.gerenciador_de_contas.contas.dtos.AtualizarContaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaSaidaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaSaidaResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta(@RequestBody @Valid ContaDTO contaDTO){
        Conta conta = modelMapper.map(contaDTO, Conta.class);

        ContaSaidaDTO contaSaidaDTO = modelMapper.map(contaService.salvarConta(conta), ContaSaidaDTO.class);
        return contaSaidaDTO;
    }

    @GetMapping
    public List<ContaSaidaResumoDTO> exibirContas(){
        List<ContaSaidaResumoDTO> contasResumoDTOS = new ArrayList<>();

        for (Conta conta : contaService.exibirContasCadastradas()){
            contasResumoDTOS.add(new ContaSaidaResumoDTO(
                    conta.getId(), conta.getNome(), conta.getValor(), conta.getStatus()));
        }
        return contasResumoDTOS;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaSaidaDTO atualizarStatusPagamento(@PathVariable int id,
                                                  @RequestBody AtualizarContaDTO atualizarContaDTO){
        return modelMapper.map(contaService.atualizarConta(id), ContaSaidaDTO.class);
    }

}
