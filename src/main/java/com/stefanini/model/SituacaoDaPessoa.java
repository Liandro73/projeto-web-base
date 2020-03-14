package com.stefanini.model;

/**
 * Enum para situação de Pessoa,
 * ATIVO ou INATIVO
 *
 * @author dernivalliandro
 */
public enum SituacaoDaPessoa {

    ATIVO(true), INATIVO(false);

    private Boolean situacao;

    private SituacaoDaPessoa(Boolean situacao) {
        this.situacao = situacao;
    }

    public Boolean getSituacao() {
        return situacao;
    }
}
