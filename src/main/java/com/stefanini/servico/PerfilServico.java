package com.stefanini.servico;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

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
public class PerfilServico implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    @Inject
    public PerfilDao perfilDao;

    /**
     * Salvar os dados de um Perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Perfil salvar(@Valid Perfil perfil) {
        return perfilDao.salvar(perfil);
    }

    /**
     * Atualizar o dados de uma Perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Perfil atualizar(@Valid Perfil perfil) {
        return perfilDao.atualizar(perfil);
    }

    /**
     * Remover uma Perfil pelo ID
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remover(Long id) {
        perfilDao.remover(id);
    }

    /**
     * Buscar uma lista de Perfis
     */
    public Optional<List<Perfil>> getList() {
        return perfilDao.getList();
    }

    /**
     * Buscar um Perfil pelo ID
     */
    public Optional<Perfil> encontrar(Long id) {
        return perfilDao.encontrar(id);
    }
}
