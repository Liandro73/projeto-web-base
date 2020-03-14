package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_PERFIL")
    private Long id;

    /**
     * Nome do Perfil
     */
    @NotNull
    @Column(name = "NO_PERFIL", unique = true)
    private String nome;

    /**
     * Decricao do Perfil
     */
    @NotNull
    @Column(name = "DS_PERFIL")
    private String descricao;

    /**
     * Data de criacao do Perfil
     */
    @Column(name = "DT_HORA_INCLUSAO")
    @NotNull
    private LocalDateTime dataHoraInclusao;

    /**
     * Data de atualizacao do Perfil
     */
    @Column(name = "DT_HORA_ALTERACAO")
    private LocalDateTime dataHoraAlteracao;
}
