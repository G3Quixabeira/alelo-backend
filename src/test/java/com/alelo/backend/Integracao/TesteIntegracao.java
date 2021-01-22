package com.alelo.backend.Integracao;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.repository.ClienteRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TesteIntegracao {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    @Order(1)
    public void cadastrarUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);


        ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity("http://localhost:"+port+"/cliente/1", cliente, Object[].class);
        assertEquals(200, responseEntity.getStatusCode());
    }

    @Test
    @Order(2)
    public void recuperarUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);

        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:"+port+"/cliente/1", Object[].class);

        assertEquals("Sucesso", cliente, responseEntity.getBody());
    }

}
