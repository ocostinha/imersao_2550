package br.com.fiap.imersao_2550.core.business.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.commons.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.imersao_2550.core.business.EnderecoBusiness;
import br.com.fiap.imersao_2550.core.domain.Endereco;
import br.com.fiap.imersao_2550.core.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoBusinessImpl implements EnderecoBusiness {
    @Autowired
    EnderecoService service;

    @Override
    public Endereco cadatrar(Endereco dominio) {
        return service.cadatrar(dominio);
    }

    @Override
    public List<Endereco> consultarTodos() {
        return service.consultarTodos();
    }

    @Override
    public Endereco consultarPorId(Long id) {
        return service.consultarPorId(id);
    }

    @Override
    public Endereco atualizarLogradouro(Long id, String logradouro) {
        try {
            return service.atualizarLogradouro(id, logradouro);
        } catch (NotFoundException ex) {
            throw new RegistroNaoEncontradoException();
        }
    }

    @Override
    public Endereco sobrescreverRegistro(Long id, Endereco dominio) {
        try {
            return service.sobrescreverRegistro(id, dominio);
        } catch (NotFoundException ex) {
            throw new RegistroNaoEncontradoException();
        }
    }

    @Override
    public void deletar(Long id) {
        service.deletar(id);
    }
}
