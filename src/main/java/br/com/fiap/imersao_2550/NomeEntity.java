package br.com.fiap.imersao_2550;

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

    public NomeEntity (ContratoEntrada contratoEntrada) {
        this.nomeCompleto = contratoEntrada.getNome() + " " + contratoEntrada.getSobrenome();
    }

    public void setNomeCompleto(ContratoEntrada contratoEntrada) {
        this.nomeCompleto = contratoEntrada.getNome() + " " + contratoEntrada.getSobrenome();
    }

    public void setNomeCompleto(String nome, String sobrenome) {
        this.nomeCompleto = nome + " " + sobrenome;
    }

    public String getNome() {
        return this.nomeCompleto.split(" ")[0];
    }
}
