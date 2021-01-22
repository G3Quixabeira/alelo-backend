package com.alelo.backend.service.Interface;

import com.alelo.backend.exceptions.ClienteNotFoundException;
import com.alelo.backend.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServiceInterface {
    List<Cliente> findAll();
    Optional<Cliente> findById(String id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    List<Cliente> findAll(String filter);
    Cliente findById(Long id) throws ClienteNotFoundException;

}
