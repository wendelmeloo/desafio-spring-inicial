package br.com.desafiospring.inicial.service;


import br.com.desafiospring.inicial.model.Gato;
import br.com.desafiospring.inicial.repository.GatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GatoService {

    private final GatoRepository gatoRepository;

    public void criarGato(br.com.desafiospring.inicial.model.Gato gato) {
        gatoRepository.save(gato);
    }

    public Optional<Gato> buscarGatoPeloId(Long id) {
        return gatoRepository.findById(id);
    }

    public List<Gato> buscarTodosGatos() {
        return gatoRepository.findAll();
    }

    public void deletarGatoPeloId(Long id){
        gatoRepository.deleteById(id);
    }

    public Gato atualizarGato(Long id, Gato gatoAtualizado) {
        return gatoRepository.findById(id).map(gato -> {
            gato.setNome(gatoAtualizado.getNome());
            gato.setCor(gatoAtualizado.getCor());
            gato.setPeso(gatoAtualizado.getPeso());
            return gatoRepository.save(gato);
        }).orElseThrow(() -> new RuntimeException("Gato não encontrado com ID: " + id));
    }
}
