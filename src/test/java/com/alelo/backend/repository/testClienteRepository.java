package com.alelo.backend.repository;

import com.alelo.backend.model.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class testClienteRepository {
    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void SalvarUmCliente() {
        LocalDate nascimento = LocalDate.of(2000,01,01);

        Cliente cliente = new Cliente();
        cliente.setNome("gleisson");
        cliente.setCpf("12345678910");
        cliente.setRg("123456");
        cliente.setNascimento(nascimento);

        clienteRepository.save(cliente);

        assertTrue(clienteRepository.existsById(1L));

    }
}
