package br.com.fiap.imersao_2550.resources.service.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.core.domain.Nome;
import br.com.fiap.imersao_2550.core.services.NomeService;
import br.com.fiap.imersao_2550.resources.database.entity.NomeEntity;
import br.com.fiap.imersao_2550.resources.database.repository.NomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NomeServiceImpl implements NomeService {
    @Autowired
    NomeRepository repository;


    @Override
    public Nome cadatrar(Nome dominio) {
        return new Nome().fromEntity(
                repository.save(
                        new NomeEntity(dominio)
                )
        );
    }

    @Override
    public List<Nome> consultarTodos() {
        List<NomeEntity> entities = repository.findAll();

        List<Nome> domains = new ArrayList<>();

        entities.forEach(entity -> {
            domains.add(new Nome().fromEntity(entity));
        });

        return domains;
    }

    @Override
    public Nome consultarPorId(Long id) {
        return new Nome().fromEntity(getById(id));
    }

    @Override
    public Nome atualizarSobrenome(Long id, String sobrenome) {
        NomeEntity entity = getById(id);

        entity.setNomeCompleto(entity.getNome() + " " + sobrenome);

        return new Nome().fromEntity(repository.save(entity));
    }

    @Override
    public Nome sobrescreverRegistro(Long id, Nome dominio) {
        NomeEntity entity = getById(id);

        entity.setNomeCompleto(dominio.getNomeCompleto());

        return new Nome().fromEntity(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        repository.delete(getById(id));
    }

    private NomeEntity getById(Long id) {
        Optional<NomeEntity> entity = repository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException();
        }

        return entity.get();
    }
}
