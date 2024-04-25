package br.com.fiap.imersao_2550;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoEntrada {
    @NotBlank
    private String nome;

    @NotBlank(message = "Informe o sobrenome")
    private String sobrenome;
}
