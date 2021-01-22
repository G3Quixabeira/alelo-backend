package com.alelo.backend.Integracao;

import com.alelo.backend.model.Cliente;
import com.alelo.backend.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TesteIntegracao {




    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void recueprarUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);


        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cliente/1", Object[].class);

        assertEquals("Sucesso", cliente, responseEntity.getBody());
    }

    @Test
    public void cadastrarUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);


        ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity("http://localhost:8080/cliente/1", cliente, Object[].class);
        //assertEquals(200, responseEntity.getStatusCode());
    }

    /*@Test
    public void editararUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente clienteOriginal = new Cliente();
        clienteOriginal.setNome("gleisson Editado");
        clienteOriginal.setCpf("12345678910");
        clienteOriginal.setRg("123456");
        clienteOriginal.setNascimento(nascimento);

        clienteRepository.save(clienteOriginal);

        Cliente clienteEditar = new Cliente();
        clienteEditar.setId(1L);
        clienteEditar.setNome("gleisson Editado");
        clienteEditar.setCpf("12345678910");
        clienteEditar.setRg("123456");
        clienteEditar.setNascimento(nascimento);

        restTemplate.put("http://localhost:8080/cliente", clienteEditar, Object[].class);
        //assertEquals(200, responseEntity.getStatusCode());
    }

    @Test
    public void excluirUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson Editado");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);


        assrestTemplate.delete("http://localhost:8080/cliente", cliente, Object[].class);
        //assertEquals(200, responseEntity.getStatusCode());
    }*/
}
