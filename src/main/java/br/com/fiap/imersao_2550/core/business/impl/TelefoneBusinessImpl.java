package br.com.fiap.imersao_2550.core.business.impl;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.commons.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.imersao_2550.core.business.TelefoneBusiness;
import br.com.fiap.imersao_2550.core.domain.Telefone;
import br.com.fiap.imersao_2550.core.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelefoneBusinessImpl implements TelefoneBusiness {
    @Autowired
    private TelefoneService service;

    @Override
    public Telefone cadatrar(Telefone dominio) {
        return service.cadatrar(dominio);
    }

    @Override
    public List<Telefone> consultarTodos() {
        return service.consultarTodos();
    }

    @Override
    public Telefone consultarPorId(Long id) {
        return service.consultarPorId(id);
    }

    @Override
    public Telefone atualizarCelular(Long id, Long dddCelular, Long celular) {
        try {
            return service.atualizarCelular(id, dddCelular, celular);
        } catch (NotFoundException ex) {
            throw new RegistroNaoEncontradoException();
        }
    }

    @Override
    public Telefone atualizarFixo(Long id, Long dddFixo, Long fixo) {
        try {
            return service.atualizarFixo(id, dddFixo, fixo);
        } catch (NotFoundException ex) {
            throw new RegistroNaoEncontradoException();
        }
    }

    @Override
    public Telefone sobrescreverRegistro(Long id, Telefone dominio) {
        return service.sobrescreverRegistro(id, dominio);
    }

    @Override
    public void deletar(Long id) {
        service.deletar(id);
    }
}
