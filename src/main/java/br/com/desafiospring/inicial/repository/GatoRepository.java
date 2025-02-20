package br.com.desafiospring.inicial.repository;

import org.springframework.stereotype.Repository;
import br.com.desafiospring.inicial.model.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GatoRepository extends JpaRepository<Gato, Long> {
}
