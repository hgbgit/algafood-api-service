package com.algaworks.algafoodapi.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {

    private String nome;

    private String telefone;

    private String email;

    private boolean ativo;

    public void ativar() {
        this.ativo = true;
    }

}
