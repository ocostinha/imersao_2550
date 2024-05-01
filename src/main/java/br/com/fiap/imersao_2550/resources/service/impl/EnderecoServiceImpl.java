package br.com.fiap.imersao_2550.resources.service.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.commons.mappers.EnderecoMapper;
import br.com.fiap.imersao_2550.core.domain.Endereco;
import br.com.fiap.imersao_2550.core.services.EnderecoService;
import br.com.fiap.imersao_2550.resources.database.entity.EnderecoEntity;
import br.com.fiap.imersao_2550.resources.database.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private EnderecoMapper mapper;

    @Override
    public Endereco cadatrar(Endereco dominio) {
        return mapper.toDomain(repository.save(mapper.toEntity(dominio)));
    }

    @Override
    public List<Endereco> consultarTodos() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Endereco consultarPorId(Long id) {
        return mapper.toDomain(getById(id));
    }

    @Override
    public Endereco atualizarLogradouro(Long id, String logradouro) {
        EnderecoEntity entity = getById(id);

        entity.setLogradouro(logradouro);

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Endereco sobrescreverRegistro(Long id, Endereco dominio) {
        EnderecoEntity entity = getById(id);

        entity.setLogradouro(dominio.getLogradouro());
        entity.setNumero(dominio.getNumero());

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.delete(getById(id));
    }

    private EnderecoEntity getById(Long id) {
        Optional<EnderecoEntity> entity = repository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException();
        }

        return entity.get();
    }
}
