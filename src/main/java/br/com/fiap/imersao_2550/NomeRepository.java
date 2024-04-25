package br.com.fiap.imersao_2550;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NomeRepository extends JpaRepository<NomeEntity, Long> {
}
