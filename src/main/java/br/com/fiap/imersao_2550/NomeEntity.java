package br.com.fiap.imersao_2550;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NOME")
public class NomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nomeCompleto;
}
