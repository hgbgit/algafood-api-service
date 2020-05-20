package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.data.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
@TipoNotificador(NivelUrgencia.URGENTE)
public class NoticadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS no telefone %s: %s", cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
