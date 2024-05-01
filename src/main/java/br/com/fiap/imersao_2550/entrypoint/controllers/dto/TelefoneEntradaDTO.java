package br.com.fiap.imersao_2550.entrypoint.controllers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneEntradaDTO {
    @NotNull
    private Long dddCelular;

    @NotNull
    private String nome;

    @NotNull
    private Long celular;

    @NotNull
    private Long dddFixo;

    @NotNull
    private Long fixo;
}
