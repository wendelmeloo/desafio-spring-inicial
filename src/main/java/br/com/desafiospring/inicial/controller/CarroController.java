package br.com.desafiospring.inicial.controller;

import br.com.desafiospring.inicial.model.Carro;
import br.com.desafiospring.inicial.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCarro(@RequestBody Carro carro) {
        carroService.criarCarro(carro);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Carro> buscarCarroPeloId(@PathVariable Long id) {
        return carroService.buscarCarroPeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Carro> buscarTodosCarros() {
        return carroService.buscarTodosCarros();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCarroPeloId(@PathVariable Long id) {
        carroService.deletarCarroPeloId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        Carro carroAtualizado = carroService.atualizarCarro(id, carro);
        return ResponseEntity.ok(carroAtualizado);
    }

}
