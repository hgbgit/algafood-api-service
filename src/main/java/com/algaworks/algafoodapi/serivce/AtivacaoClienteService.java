package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AtivacaoClienteService {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostConstruct
    public void init() {
        System.out.println("INIT: " + this.getClass()
                                          .getName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY: " + this.getClass()
                                             .getName());
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
