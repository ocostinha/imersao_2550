package br.com.fiap.imersao_2550.core.business;

import br.com.fiap.imersao_2550.core.domain.Nome;

import java.util.List;

public interface NomeBusiness {
    Nome cadatrar(Nome dominio);
    List<Nome> consultarTodos();
    Nome consultarPorId(Long id);
    Nome atualizarSobrenome(Long id, String sobrenome);
    Nome sobrescreverRegistro(Long id, Nome dominio);
    void deletar(Long id);
}
