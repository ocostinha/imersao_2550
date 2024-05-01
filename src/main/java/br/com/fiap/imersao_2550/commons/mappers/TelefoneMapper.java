package br.com.fiap.imersao_2550.commons.mappers;

import br.com.fiap.imersao_2550.core.domain.Telefone;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.TelefoneEntradaDTO;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.TelefoneSaidaDTO;
import br.com.fiap.imersao_2550.resources.database.entity.TelefoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TelefoneMapper {
    TelefoneEntity toEntity(Telefone dominio);
    Telefone toDomain(TelefoneEntity entity);
    List<Telefone> toDomain(List<TelefoneEntity> entity);

    @Mapping(target = "teste", constant = "TESTE")
    TelefoneSaidaDTO toSaida(Telefone dominio);
    List<TelefoneSaidaDTO> toSaida(List<Telefone> dominio);
    Telefone toDomain(TelefoneEntradaDTO entradaDTO);
}
