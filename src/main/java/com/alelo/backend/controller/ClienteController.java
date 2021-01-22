package com.alelo.backend.controller;

import com.alelo.backend.exceptions.ClienteNotFoundException;
import com.alelo.backend.model.Cliente;
import com.alelo.backend.model.Dto.ClienteDto;
import com.alelo.backend.service.Interface.ClienteServiceInterface;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteServiceInterface clienteServiceInterface;

    public ClienteController(ClienteServiceInterface clienteServiceInterface) {
        this.clienteServiceInterface = clienteServiceInterface;
    }

    @GetMapping
    @ApiOperation(value = "Lista de Clientes casdastrados")
    public List<ClienteDto> get(){
        return ClienteDto.covert(clienteServiceInterface.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consuta Cliente casdastrado pelo Id")
    public Cliente getById(@PathVariable Long id) throws ClienteNotFoundException {
        return clienteServiceInterface.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar um Cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente post(@RequestBody @Valid Cliente cliente){
        return clienteServiceInterface.save(cliente);
    }

    @PutMapping
    @ApiOperation(value = "Alterar um Cliente")
    public Cliente put(@RequestBody @Valid  Cliente cliente){
        return clienteServiceInterface.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um Cliente")
    public void delete(@RequestBody  @PathVariable Long id, Cliente cliente){
        clienteServiceInterface.deleteById(id);
    }
}
