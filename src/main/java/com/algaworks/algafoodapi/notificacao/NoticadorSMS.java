package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.domain.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
public class NoticadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS no telefone %s: %s", cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
