package br.com.fiap.imersao_2550.resources.database.repository;

import br.com.fiap.imersao_2550.resources.database.entity.NomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomeRepository extends JpaRepository<NomeEntity, Long> {
}
