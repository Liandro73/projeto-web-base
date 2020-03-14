package com.stefanini.resource;

import com.stefanini.model.Perfil;
import com.stefanini.servico.PerfilServico;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

    @Inject
    private PerfilServico perfilServico;

    /**
     * Adiciona nova Perfil ao cadastro
     *
     * @param perfil: Novo perfil
     * @return response 201 (CREATED) - Sucesso ao adicionar
     */
    @POST
    public Response salvar(Perfil perfil) {
        try {
            perfilServico.salvar(perfil);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO ADICIONAR PERFIL").build();
        }
        return Response.status(Status.CREATED.getStatusCode()).entity("SUCESSO AO ADICIONAR PERFIL").build();
    }

    /**
     * Lista todos os Perfis cadastrados
     *
     * @return response 200 (OK) - Sucesso ao listar
     */
    @GET
    public Response obterTodos() {
        Response obterTodosPerfis = null;
        try {
            obterTodosPerfis = Response.ok(perfilServico.getList().get()).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR LISTA DE PERFIS").build();
        }
        return obterTodosPerfis;
    }

    /**
     * Encontra um Perfil utilizando a ID
     *
     * @param id: id do perfil
     * @return response 200 (OK) - Sucesso ao obter perfil
     */
    @GET
    @Path("id/{id}")
    public Response obterPorId(@PathParam("id") Long id) {
        Response obterTodosPerfisId = null;
        try {
            obterTodosPerfisId = Response.ok(perfilServico.encontrar(id).get()).build();
            ;
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR PERFIL, PELO ID").build();
        }
        return obterTodosPerfisId;
    }

    /**
     * Atualiza um Perfil cadastrado
     *
     * @param perfil: Perfil atualizado
     * @return response 200 (OK) - Sucesso ao atualizar
     */
    @PUT
    public Response atualizar(Perfil perfil) {
        try {
            perfilServico.atualizar(perfil);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO ATUALIZAR PERFIL").build();
        }
        return Response.status(Status.OK).entity("SUCESSO AO ATUALIZAR PERFIL").build();
    }

    /**
     * Remove um Perfil do cadastro
     *
     * @param id: id do perfil
     * @return response 200 (OK) - Conseguiu remover
     */
    @DELETE
    @Path("id/{id}")
    public Response remover(@PathParam("id") Long id) {
        try {
            perfilServico.remover(id);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO REMOVER PERFIL").build();
        }
        return Response.status(Status.OK).entity("SUCESSO AO REMOVER PERFIL").build();
    }
}
