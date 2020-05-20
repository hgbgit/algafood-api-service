package com.algaworks.algafoodapi.api;

import com.algaworks.algafoodapi.data.entity.Cozinha;
import com.algaworks.algafoodapi.data.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    private final CozinhaRepository cozinhaRepository;

    public CozinhaController(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cozinha buscar(@PathVariable Long id) {
        return cozinhaRepository.findById(id)
                                .get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha criar(@RequestBody Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cozinha atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        Cozinha currentCozinha = cozinhaRepository.findById(id)
                                                  .orElseThrow(RuntimeException::new);

        BeanUtils.copyProperties(cozinha, currentCozinha, "id");

        return cozinhaRepository.save(currentCozinha);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        cozinhaRepository.findById(id)
                         .ifPresentOrElse(c -> cozinhaRepository.deleteById(c.getId()), () -> {
                             throw new RuntimeException();
                         });
    }
}
