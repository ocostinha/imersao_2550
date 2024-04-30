package br.com.fiap.imersao_2550.resources.database.entity;

import br.com.fiap.imersao_2550.core.domain.Nome;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NOME")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nomeCompleto;

    public NomeEntity (Nome dominio) {
        this.nomeCompleto = dominio.getNomeCompleto();
    }

    public String getNome() {
        return this.nomeCompleto.split(" ")[0];
    }
}
