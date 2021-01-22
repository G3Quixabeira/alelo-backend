package com.alelo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    String nome;
    @NotNull(message = "O cpf não pode ser nulo")
    String cpf;
    @NotNull(message = "O rg não pode ser nulo")
    String rg;
    @NotNull(message = "A Data de Nacimento não pode ser nulo")
    LocalDate nascimento;
}
