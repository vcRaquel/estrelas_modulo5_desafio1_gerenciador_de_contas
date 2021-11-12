package br.com.zup.gerenciador_de_contas.contas.controller;

import br.com.zup.gerenciador_de_contas.contas.Conta;
import br.com.zup.gerenciador_de_contas.contas.service.ContaService;
import br.com.zup.gerenciador_de_contas.contas.dtos.AtualizarContaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaSaidaDTO;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaSaidaResumoDTO;
import br.com.zup.gerenciador_de_contas.enuns.Status;
import br.com.zup.gerenciador_de_contas.enuns.Tipo;
import br.com.zup.gerenciador_de_contas.exceptionsPernonalizadas.StatusInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public List<ContaSaidaResumoDTO> exibirContas(@RequestParam(required = false) Status status,
                                                  @RequestParam(required = false) Tipo tipo,
                                                  @RequestParam(required = false) Double valor){
        List<ContaSaidaResumoDTO> contasResumoDTOS = new ArrayList<>();

        for (Conta conta : contaService.exibirContasCadastradas(status, tipo, valor)){
            contasResumoDTOS.add(new ContaSaidaResumoDTO(
                    conta.getId(), conta.getNome(), conta.getValor(), conta.getStatus()));
        }
        return contasResumoDTOS;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaSaidaDTO atualizarStatusPagamento(@PathVariable int id,
                                                  @RequestBody AtualizarContaDTO atualizarContaDTO){
        if (atualizarContaDTO.getStatus() == Status.PAGO){
            return modelMapper.map(contaService.atualizarConta(id), ContaSaidaDTO.class);
        }
        throw new StatusInvalidoException("Status inválido para a requisição");
    }

    @GetMapping(path = {"/{id}"})
    public ContaSaidaDTO exibirConta(@PathVariable int id){
        return modelMapper.map(contaService.retornarContaPorId(id), ContaSaidaDTO.class);
    }

}
