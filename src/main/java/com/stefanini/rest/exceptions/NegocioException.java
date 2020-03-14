package com.stefanini.rest.exceptions;

import com.stefanini.rest.Mensagem;

public class NegocioException extends Exception {

    /**
     * Serializacao da classe
     */
    private static final long serialVersionUID = 1L;

    private Mensagem mensagem;

    public NegocioException(Mensagem mensagem) {
        super(mensagem.getTexto());

        this.mensagem = mensagem;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }
}
