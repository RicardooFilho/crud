package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.exceptions.CarroException;
import br.edu.unicesumar.crud.model.domain.Carro;
import br.edu.unicesumar.crud.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroRepository carroRepository;

    @GetMapping
    public List<Carro> getAll() {
        return carroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Carro getCarroById(@PathVariable Long id) throws CarroException {
        return carroRepository.findById(id).orElseThrow(CarroException :: new);
    }
}
