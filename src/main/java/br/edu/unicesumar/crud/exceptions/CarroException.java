package br.edu.unicesumar.crud.exceptions;

import br.edu.unicesumar.crud.model.repository.CarroRepository;

public class CarroException extends Exception{
    public CarroException() {
        super("Carro não encontrado");
    }
}
