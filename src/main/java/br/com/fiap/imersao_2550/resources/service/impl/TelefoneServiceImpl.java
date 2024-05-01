package br.com.fiap.imersao_2550.resources.service.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.commons.mappers.TelefoneMapper;
import br.com.fiap.imersao_2550.core.domain.Telefone;
import br.com.fiap.imersao_2550.core.services.TelefoneService;
import br.com.fiap.imersao_2550.resources.database.entity.TelefoneEntity;
import br.com.fiap.imersao_2550.resources.database.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneServiceImpl implements TelefoneService {
    @Autowired
    TelefoneRepository repository;

    @Autowired
    TelefoneMapper mapper;

    @Override
    public Telefone cadatrar(Telefone dominio) {
        return mapper.toDomain(repository.save(mapper.toEntity(dominio)));
    }

    @Override
    public List<Telefone> consultarTodos() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Telefone consultarPorId(Long id) {
        return mapper.toDomain(getById(id));
    }

    @Override
    public Telefone atualizarCelular(Long id, Long dddCelular, Long celular) {
        TelefoneEntity entity = getById(id);

        entity.setDddCelular(dddCelular);
        entity.setCelular(celular);

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Telefone atualizarFixo(Long id, Long dddFixo, Long fixo) {
        TelefoneEntity entity = getById(id);

        entity.setDddFixo(dddFixo);
        entity.setFixo(fixo);

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Telefone sobrescreverRegistro(Long id, Telefone dominio) {
        TelefoneEntity entity = getById(id);

        entity.setDddCelular(dominio.getDddCelular());
        entity.setCelular(dominio.getCelular());
        entity.setDddFixo(dominio.getDddFixo());
        entity.setFixo(dominio.getFixo());

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {

    }

    private TelefoneEntity getById(Long id) {
        Optional<TelefoneEntity> entity = repository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException();
        }

        return entity.get();
    }
}
