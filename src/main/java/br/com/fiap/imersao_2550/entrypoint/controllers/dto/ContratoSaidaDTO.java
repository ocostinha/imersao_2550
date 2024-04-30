package br.com.fiap.imersao_2550.entrypoint.controllers.dto;

import br.com.fiap.imersao_2550.core.domain.Nome;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoSaidaDTO {
    private Long id;
    private String nomeCompleto;

    public ContratoSaidaDTO(Nome dominio) {
        this.id = dominio.getId();
        this.nomeCompleto = dominio.getNomeCompleto();
    }
}
