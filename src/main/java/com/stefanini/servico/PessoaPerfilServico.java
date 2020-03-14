package com.stefanini.servico;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Classe de servico, as regras de negocio devem estar nessa classe
 *
 * @author dernivalliandro
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaPerfilServico implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    @Inject
    public PessoaPerfilDao pessoaPerfilDao;

    /**
     * Salvar os dados de um vinculo de Pessoa com Perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public PessoaPerfil salvar(@Valid PessoaPerfil pessoaPerfil) {
        return pessoaPerfilDao.salvar(pessoaPerfil);
    }

    /**
     * Atualizar os dados de um vinculo de Pessoa com Perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public PessoaPerfil atualizar(@Valid PessoaPerfil pessoaPerfil) {
        return pessoaPerfilDao.atualizar(pessoaPerfil);
    }

    /**
     * Remover um vinculo de Pessoa com Perfil pelo ID
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remover(Long id) {
        pessoaPerfilDao.remover(id);
    }

    /**
     * Buscar uma lista de vinculos de Pessoas com Perfis
     */
    public Optional<List<PessoaPerfil>> getList() {
        return pessoaPerfilDao.getList();
    }

    /**
     * Buscar um vinculo de Pessoa com Perfil pelo ID
     */
    public Optional<PessoaPerfil> encontrar(Long id) {
        return pessoaPerfilDao.encontrar(id);
    }
}
