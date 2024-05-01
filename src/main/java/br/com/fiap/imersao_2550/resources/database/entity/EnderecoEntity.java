package br.com.fiap.imersao_2550.resources.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENDERECO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String logradouro;

    @Column
    private String numero;
}
