package br.com.fiap.imersao_2550.entrypoint.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoEntradaDTO {
    @NotBlank
    private String nome;

    @NotBlank(message = "Informe o sobrenome")
    private String sobrenome;

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }
}
