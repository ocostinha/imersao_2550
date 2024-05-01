package br.com.fiap.imersao_2550.entrypoint.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntradaDTO {
    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;
}
