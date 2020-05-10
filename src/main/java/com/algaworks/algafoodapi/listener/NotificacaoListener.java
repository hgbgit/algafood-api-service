package com.algaworks.algafoodapi.listener;

import com.algaworks.algafoodapi.notificacao.NivelUrgencia;
import com.algaworks.algafoodapi.notificacao.Notificador;
import com.algaworks.algafoodapi.notificacao.TipoNotificador;
import com.algaworks.algafoodapi.serivce.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoListener {

    @Autowired
    @TipoNotificador(NivelUrgencia.NORMAL)
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent) {
        notificador.notificar(clienteAtivadoEvent.getCliente(), "Seu cadastro está ativo!");
    }
}
