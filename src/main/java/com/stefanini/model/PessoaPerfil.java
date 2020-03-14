package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TB_PESSOA_PERFIL")
public class PessoaPerfil implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID da Tabela
     */
    @Id
    @Column(name = "CO_SEQ_PESSOAL_PERFIL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Mapeamento dos Perfis
     */
    @ManyToOne
    @JoinColumn(name = "CO_SEQ_PERFIL", referencedColumnName = "CO_SEQ_PERFIL", nullable = false)
    private Perfil perfil;

    /**
     * Mapeamento das Pessoas
     */
    @ManyToOne
    @JoinColumn(name = "CO_SEQ_PESSOA", referencedColumnName = "CO_SEQ_PESSOA", nullable = false)
    private Pessoa pessoa;
}
