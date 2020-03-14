package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_ENDERECO")
    private Long id;

    /**
     * CEP do Endereco
     */
    @Column(name = "DS_CEP")
    private String cep;

    /**
     * UF do Endereco
     */
    @Column(name = "CO_UF")
    private String uf;

    /**
     * Cidade do Endereco
     */
    @Column(name = "DS_CIDADE")
    private String localidade;

    /**
     * Bairro do Endereco
     */
    @Column(name = "DS_BAIRRO")
    private String bairro;

    /**
     * Complemento do Endereco
     */
    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    /**
     * Logradouro do Endereco
     */
    @Column(name = "DS_LOGRADOURO")
    private String logradouro;

    /**
     * Unidirecional
     * Somente Pessoa acessa endereco
     */
    @Column(name = "CO_SEQ_PESSOA")
    private Long idPessoa;
}
