package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.exceptions.PessoaException;
import br.edu.unicesumar.crud.model.domain.Pessoa;
import br.edu.unicesumar.crud.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> all() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa byId(@PathVariable Long id) throws PessoaException {
    return pessoaRepository.findById(id).orElseThrow(PessoaException::new);
    }

    //Método personalizado do PessoaRepository
    @GetMapping("/consulta")
    public Pessoa searchByDocumento(@RequestParam("doc") String doc) {
        return pessoaRepository.findByDocumentoEquals(doc);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa novaPessoa) {
        return pessoaRepository.save(novaPessoa);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa editPessoa) {
        Pessoa pessoaDb = pessoaRepository.findById(id).orElse(new Pessoa());

        pessoaDb.setNome(editPessoa.getNome());
        pessoaDb.setDocumento(editPessoa.getDocumento());

        return pessoaRepository.save(pessoaDb);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }




}