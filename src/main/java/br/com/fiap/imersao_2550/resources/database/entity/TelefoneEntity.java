package br.com.fiap.imersao_2550.resources.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TELEFONE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;

    @Column(length = 2)
    private Long dddCelular;

    @Column
    private Long celular;

    @Column(length = 2)
    private Long dddFixo;

    @Column
    private Long fixo;
}
