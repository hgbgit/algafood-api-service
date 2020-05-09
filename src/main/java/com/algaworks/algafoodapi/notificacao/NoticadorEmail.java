package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.domain.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("email")
public class NoticadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
