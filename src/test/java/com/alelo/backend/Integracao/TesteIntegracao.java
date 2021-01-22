package com.alelo.backend.Integracao;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

public class TesteIntegracao {
    @Autowired
    Cliente cliente;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ClienteRepository clienteRepository;


    public void recueprarUmClientes() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);


        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/clientes", Object[].class);
        Object[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertEquals()
    }
}
