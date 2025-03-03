package br.com.desafiospring.inicial.service;


import br.com.desafiospring.inicial.model.Carro;
import br.com.desafiospring.inicial.model.Gato;
import br.com.desafiospring.inicial.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    public void criarCarro(Carro carro) {
        carroRepository.save(carro);
    }

    public Optional<Carro> buscarCarroPeloId(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> buscarTodosCarros() { return carroRepository.findAll(); }

    public void deletarCarroPeloId(Long id) {
        carroRepository.deleteById(id);
    }

    public Carro atualizarCarro(Long id, Carro carroAtualizado) {
        return carroRepository.findById(id).map(carro -> {
            carro.setMarca(carroAtualizado.getMarca());
            carro.setModelo(carroAtualizado.getModelo());
            carro.setAno(carroAtualizado.getAno());
            return carroRepository.save(carro);
        }).orElseThrow(() -> new RuntimeException("Carro nao encontrado com ID: " + id));
    }
}
