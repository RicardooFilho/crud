package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.model.domain.Autor;
import br.edu.unicesumar.crud.model.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping()
    public ModelAndView all() {
        ModelAndView view = new ModelAndView("lista-autor");

        view.addObject("autores", autorRepository.findAll());

        return view;
    }

    @GetMapping("/novo")
    public ModelAndView newAutor() {

        ModelAndView view= new ModelAndView("form-autor");

        view.addObject("autor", new Autor());

        return view;
    }

    @PostMapping
    public String create(Autor novoAutor) {
        autorRepository.save(novoAutor);

        return "redirect:/autor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        autorRepository.deleteById(id);

        return "redirect:/autor";
    }


}
