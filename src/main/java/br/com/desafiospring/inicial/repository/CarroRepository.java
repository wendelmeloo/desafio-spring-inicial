package br.com.desafiospring.inicial.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.desafiospring.inicial.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
