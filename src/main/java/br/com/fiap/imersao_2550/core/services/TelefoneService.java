package br.com.fiap.imersao_2550.core.services;

import br.com.fiap.imersao_2550.core.domain.Telefone;

import java.util.List;

public interface TelefoneService {
    Telefone cadatrar(Telefone dominio);
    List<Telefone> consultarTodos();
    Telefone consultarPorId(Long id);
    Telefone atualizarCelular(Long id, Long dddCelular, Long celular);
    Telefone atualizarFixo(Long id, Long dddFixo, Long fixo);
    Telefone sobrescreverRegistro(Long id, Telefone dominio);
    void deletar(Long id);
}
