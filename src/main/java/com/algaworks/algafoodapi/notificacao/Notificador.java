package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.data.entity.Cliente;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);
}
