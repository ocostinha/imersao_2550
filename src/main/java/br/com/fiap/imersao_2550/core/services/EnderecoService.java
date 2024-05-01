package br.com.fiap.imersao_2550.core.services;

import br.com.fiap.imersao_2550.core.domain.Endereco;

import java.util.List;

public interface EnderecoService {
    Endereco cadatrar(Endereco dominio);
    List<Endereco> consultarTodos();
    Endereco consultarPorId(Long id);
    Endereco atualizarLogradouro(Long id, String logradouro);
    Endereco sobrescreverRegistro(Long id, Endereco dominio);
    void deletar(Long id);
}
