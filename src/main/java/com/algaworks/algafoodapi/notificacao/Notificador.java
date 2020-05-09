package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.domain.Cliente;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);
}
