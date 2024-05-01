package br.com.fiap.imersao_2550.entrypoint.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneSaidaDTO {
    private Long id;
    private String nome;
    private Long dddCelular;
    private Long celular;
    private Long dddFixo;
    private Long fixo;
    private String teste;
}
