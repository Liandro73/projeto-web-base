package com.stefanini.resource;

import com.stefanini.model.Endereco;
import com.stefanini.servico.EnderecoServico;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    private EnderecoServico enderecoServico;

    /**
     * Adiciona novo Endereco ao cadastro
     *
     * @param endereco: Novo endereco
     * @return response 201 (CREATED) - Sucesso ao adicionar
     */
    @POST
    public Response salvar(Endereco endereco) {
        try {
            enderecoServico.salvar(endereco);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ERRO AO ADICIONAR ENDEREÇO").build();
        }
        return Response.status(Response.Status.CREATED.getStatusCode()).entity("SUCESSO AO ADICIONAR ENDEREÇO").build();
    }

    /**
     * Lista todos od Enderecos cadastrados
     *
     * @return response 200 (OK) - Sucesso ao listar
     */
    @GET
    public Response obterTodos() {
        Response obterTodosEnderecos = null;
        try {
            obterTodosEnderecos = Response.ok(enderecoServico.getList().get()).build();
            ;
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR LISTA DE ENDEREÇOS").build();
        }
        return obterTodosEnderecos;
    }

    /**
     * Encontra o Endereco utilizando o ID
     *
     * @return response 200 (OK) - Sucesso ao obter endereco
     */
    @GET
    @Path("id/{id}")
    public Response obterPorId(@PathParam("id") Long id) {
        Response obterTodosEnderecosId = null;
        try {
            obterTodosEnderecosId = Response.ok(enderecoServico.encontrar(id).get()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR ENDEREÇO, PELO ID").build();
        }
        return obterTodosEnderecosId;
    }

    /**
     * Atualiza um Endereco cadastrado
     *
     * @param endereco: Endereco atualizado
     * @return response 200 (OK) - Sucesso ao atualizar
     */
    @PUT
    public Response atualizar(Endereco endereco) {
        try {
            enderecoServico.atualizar(endereco);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ERRO AO ATUALIZAR ENDEREÇO").build();
        }
        return Response.status(Response.Status.OK).entity("SUCESSO AO ATUALIZAR ENDEREÇO").build();
    }

    /**
     * Remove um Endereco do cadastro
     *
     * @param id: id do endereco
     * @return response 200 (OK) - Sucesso ao remover
     */
    @DELETE
    @Path("id/{id}")
    public Response remover(@PathParam("id") Long id) {
        try {
            enderecoServico.remover(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ERRO AO REMOVER ENDEREÇO").build();
        }
        return Response.status(Response.Status.OK).entity("SUCESSO AO REMOVER ENDEREÇO").build();
    }
}
