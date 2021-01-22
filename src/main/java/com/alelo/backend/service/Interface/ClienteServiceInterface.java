package com.alelo.backend.service.Interface;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.model.Dto.ClienteDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClienteServiceInterface {
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    List<ClienteDto> findAll(String filter);
    Optional<Cliente> findById(String id);
    Cliente findById(Long id);
}
