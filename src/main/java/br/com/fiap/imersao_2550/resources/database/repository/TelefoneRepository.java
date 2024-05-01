package br.com.fiap.imersao_2550.resources.database.repository;

import br.com.fiap.imersao_2550.resources.database.entity.TelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {
}
