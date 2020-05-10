package com.algaworks.algafoodapi.listener;

import com.algaworks.algafoodapi.serivce.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaListener {

    @EventListener
    public void emissaoNotaFiscalClienteListener(ClienteAtivadoEvent clienteAtivadoEvent) {
        System.out.println("Emitindo nota fiscal pro cliente: " + clienteAtivadoEvent.getCliente()
                                                                                     .getNome());
    }
}
