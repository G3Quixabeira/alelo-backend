package com.alelo.backend.controller;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.model.Dto.ClienteDto;
import com.alelo.backend.repository.ClienteRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    @ApiOperation(value = "Lista de Clientes casdastrados")
    public List<ClienteDto> get(){
        return ClienteDto.covert(clienteRepository.findAll());
    }

    @PostMapping("/cliente")
    @ApiOperation(value = "Cadastrar um Cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente post(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/cliente")
    @ApiOperation(value = "Alterar um Cliente")
    public Cliente put(@RequestBody @Valid  Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/cliente")
    @ApiOperation(value = "Deletar um Cliente")
    public void delete(@RequestBody @Valid  Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
