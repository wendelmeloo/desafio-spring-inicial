package br.com.desafiospring.inicial.controller;

import br.com.desafiospring.inicial.model.Gato;
import br.com.desafiospring.inicial.service.GatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gatos")
@RequiredArgsConstructor
public class GatoController {

    private final GatoService gatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarGato(@RequestBody Gato gato) {
        gatoService.criarGato(gato);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Gato> buscarGatoPeloId(@PathVariable Long id) {
        return gatoService.buscarGatoPeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Gato> buscarTodosGatos() {
        return gatoService.buscarTodosGatos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarGatoPeloId(@PathVariable Long id) {
        gatoService.deletarGatoPeloId(id);
    }

}
