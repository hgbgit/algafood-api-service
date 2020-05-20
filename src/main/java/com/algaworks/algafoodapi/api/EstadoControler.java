package com.algaworks.algafoodapi.api;

import com.algaworks.algafoodapi.data.entity.Estado;
import com.algaworks.algafoodapi.data.repository.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoControler {

    private final EstadoRepository estadoRepository;

    public EstadoControler(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }
}
