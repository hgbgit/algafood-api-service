package com.algaworks.algafoodapi.api;

import com.algaworks.algafoodapi.data.entity.Cliente;
import com.algaworks.algafoodapi.serivce.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

    private final AtivacaoClienteService ativacaoClienteService;

    public PrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    public String hello() {

        Cliente joao = new Cliente("João", "3499998888", "joao@email.com", false);
        ativacaoClienteService.ativar(joao);

        return "Hello!";
    }
}
