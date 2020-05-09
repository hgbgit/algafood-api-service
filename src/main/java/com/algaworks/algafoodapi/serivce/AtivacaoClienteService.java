package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.domain.Cliente;
import com.algaworks.algafoodapi.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    @Qualifier("sms")
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo\n");
    }

}
