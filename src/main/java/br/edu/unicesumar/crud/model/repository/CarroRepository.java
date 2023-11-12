package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
