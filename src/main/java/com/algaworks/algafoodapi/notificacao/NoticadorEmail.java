package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.domain.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@TipoNotificador(NivelUrgencia.NORMAL)
public class NoticadorEmail implements Notificador {

    @Value("${notificador.email.host}")
    private String host;

    @Value("${notificador.email.porta}")
    private Integer porta;

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Host: " + host);
        System.out.println("Porta: " + porta);
        System.out.printf("Notificando %s através do email %s: %s", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
