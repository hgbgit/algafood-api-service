package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.domain.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@TipoNotificador(NivelUrgencia.NORMAL)
public class NoticadorEmailMock implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("MOCK: Notificando %s através do email %s: %s", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
