package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.data.entity.Cliente;

public class ClienteAtivadoEvent {

    private Cliente cliente;

    public ClienteAtivadoEvent(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}
