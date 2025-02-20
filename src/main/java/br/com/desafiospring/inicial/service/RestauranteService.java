package br.com.desafiospring.inicial.service;

import br.com.desafiospring.inicial.model.Restaurante;
import br.com.desafiospring.inicial.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public void criarRestaurante(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    public Optional<Restaurante> buscarRestaurantePeloId(Long id){
        return restauranteRepository.findById(id);
    }

    public List<Restaurante> buscarTodosRestaurantes() {
        return restauranteRepository.findAll();
    }

    public void deletarRestaurantePeloId(Long id){
        restauranteRepository.deleteById(id);
    }
}