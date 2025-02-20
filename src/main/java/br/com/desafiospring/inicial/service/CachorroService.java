package br.com.desafiospring.inicial.service;


import br.com.desafiospring.inicial.model.Cachorro;
import br.com.desafiospring.inicial.model.Carro;
import br.com.desafiospring.inicial.repository.CachorroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CachorroService {

    private final CachorroRepository cachorroRepository;

    public void criarCachorro(Cachorro cachorro) {
        cachorroRepository.save(cachorro);
    }

    public Optional<Cachorro> buscarCachorroPeloId(Long id) {
        return cachorroRepository.findById(id);
    }

    public List<Cachorro> buscarTodosCachorros() {
        return cachorroRepository.findAll();
    }

    public void deletarCachorroPeloId(Long id) {
        cachorroRepository.deleteById(id);
    }
}
