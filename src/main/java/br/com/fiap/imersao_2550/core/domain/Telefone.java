package br.com.fiap.imersao_2550.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
    private String nome;
    private Long id;
    private Long dddCelular;
    private Long celular;
    private Long dddFixo;
    private Long fixo;
}
