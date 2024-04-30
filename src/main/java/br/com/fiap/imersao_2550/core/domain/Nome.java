package br.com.fiap.imersao_2550.core.domain;

import br.com.fiap.imersao_2550.entrypoint.controllers.dto.ContratoEntradaDTO;
import br.com.fiap.imersao_2550.resources.database.entity.NomeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nome {
    private Long id;
    private String nomeCompleto;

    public Nome (ContratoEntradaDTO contratoEntradaDTO) {
        this.nomeCompleto = contratoEntradaDTO.getNomeCompleto();
    }

    public Nome fromEntity (NomeEntity entity) {
        return new Nome(entity.getId(), entity.getNomeCompleto());
    }
}
