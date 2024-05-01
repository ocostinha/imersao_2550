package br.com.fiap.imersao_2550.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Long id;
    private String logradouro;
    private String numero;
}
