package br.com.fiap.imersao_2550.core.business.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NomeNaoEncontradoException;
import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.core.business.NomeBusiness;
import br.com.fiap.imersao_2550.core.domain.Nome;
import br.com.fiap.imersao_2550.core.services.NomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NomeBusinessImpl implements NomeBusiness {
    @Autowired
    NomeService service;

    @Override
    public Nome cadatrar(Nome dominio) {
        return service.cadatrar(dominio);
    }

    @Override
    public List<Nome> consultarTodos() {
        return service.consultarTodos();
    }

    @Override
    public Nome consultarPorId(Long id) {
        return service.consultarPorId(id);
    }

    @Override
    public Nome atualizarSobrenome(Long id, String sobrenome) {
        try {
            return service.atualizarSobrenome(id, sobrenome);
        } catch (NotFoundException ex) {
            throw new NomeNaoEncontradoException();
        }
    }

    @Override
    public Nome sobrescreverRegistro(Long id, Nome dominio) {
        try {
            return service.sobrescreverRegistro(id, dominio);
        } catch (NotFoundException ex) {
            throw new NomeNaoEncontradoException();
        }
    }

    @Override
    public void deletar(Long id) {
        service.deletar(id);
    }
}
