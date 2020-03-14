package com.stefanini.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author joaopedromilhome
 */
@Entity
@Data
@Table(name = "TB_PESSOA")
@NamedQueries(value = {
        @NamedQuery(name = "Pessoa.findByNome",
                query = "select p from Pessoa p where p.nome=:nome"),
        @NamedQuery(name = "Pessoa.findPerfilsAndEnderecosByNome",
                query = "select  p from Pessoa p  JOIN FETCH p.perfils JOIN FETCH p.enderecos  where p.nome=:nome")
})
public class Pessoa implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_PESSOA")
    private Long id;

    /**
     * Nome da pessoa
     */
    @NotNull
    @Column(name = "NO_NOME")
    private String nome;

    /**
     * Email da Pessoa
     */
    @NotNull
    @Email
    @Column(name = "DS_EMAIL", unique = true)
    private String email;

    /**
     * Data de Nascimento
     */
    @NotNull
    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    /**
     * Situacao da Pessoa
     */
    @NotNull
    @Column(name = "ST_PESSOA")
    private Boolean situacao;

    /**
     * Mapeamento de Enderecos Unidirecional
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CO_SEQ_PESSOA", referencedColumnName = "CO_SEQ_PESSOA")
    private Set<Endereco> enderecos;

    /**
     * Mapeamento de Perfis Unidirecional
     */
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "TB_PESSOA_PERFIL",
            joinColumns = {@JoinColumn(name = "CO_SEQ_PESSOA")},
            inverseJoinColumns = {@JoinColumn(name = "CO_SEQ_PERFIL")}
    )
    private Set<Perfil> perfils;
}