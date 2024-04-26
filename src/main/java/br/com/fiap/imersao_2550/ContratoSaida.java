package br.com.fiap.imersao_2550;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoSaida {
    private Long id;

    @JsonProperty("nome")
    private String nomeCompleto;

    public ContratoSaida(NomeEntity nomeEntity) {
        this.setId(nomeEntity.getId());
        this.setNomeCompleto(nomeEntity.getNomeCompleto());
    }
}
