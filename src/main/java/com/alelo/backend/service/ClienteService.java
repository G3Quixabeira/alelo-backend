package com.alelo.backend.service;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.repository.ClienteRepository;
import com.alelo.backend.service.Interface.ClienteServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClienteServiceInterface {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findAll(String filter) {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return Optional.empty();
    }


}
