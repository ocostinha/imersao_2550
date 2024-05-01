package br.com.fiap.imersao_2550.commons.mappers;

import br.com.fiap.imersao_2550.core.domain.Endereco;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.EnderecoEntradaDTO;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.EnderecoSaidaDTO;
import br.com.fiap.imersao_2550.resources.database.entity.EnderecoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EnderecoMapper {
    Endereco toDomain(EnderecoEntradaDTO dto);
    EnderecoSaidaDTO toSaida(Endereco domain);
    List<EnderecoSaidaDTO> toSaida(List<Endereco> domain);
    Endereco toDomain(EnderecoEntity entity);
    List<Endereco> toDomain(List<EnderecoEntity> entity);
    EnderecoEntity toEntity(Endereco domain);
}
