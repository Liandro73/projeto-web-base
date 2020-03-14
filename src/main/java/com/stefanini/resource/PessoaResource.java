package com.stefanini.resource;

import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaServico pessoaServico;

    /**
     * Adiciona nova Pessoa ao cadastro
     *
     * @param pessoa: Nova pessoa
     * @return response 201 (CREATED) - Sucesso ao adicionar
     */
    @POST
    public Response salvar(Pessoa pessoa) {
        try {
            pessoaServico.salvar(pessoa);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO ADICIONAR PESSOA").build();
        }
        return Response.status(Status.CREATED.getStatusCode()).entity("SUCESSO AO ADICIONAR PESSOA").build();
    }

    /**
     * Lista todas as Pessoas cadastradas
     *
     * @return response 200 (OK) - Sucesso ao listar
     */
    @GET
    public Response obterTodos() {
        Response obterTodasPessoas = null;
        try {
            obterTodasPessoas = Response.ok(pessoaServico.getList().get()).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR LISTA DE PESSOAS").build();
        }
        return obterTodasPessoas;
    }

    /**
     * Encontra uma Pessoa utilizando a ID
     *
     * @param id: id da pessoa
     * @return response 200 (OK) - Sucesso ao encontrar pessoa
     */
    @GET
    @Path("id/{id}")
    public Response obterPorId(@PathParam("id") Long id) {
        Response obterTodasPessoasId = null;
        try {
            obterTodasPessoasId = Response.ok(pessoaServico.encontrar(id).get()).build();
            ;
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR PESSOA, PELO ID").build();
        }
        return obterTodasPessoasId;
    }

    /**
     * Atualiza uma Pessoa cadastrada
     *
     * @param pessoa: Pessoa atualizada
     * @return response 200 (OK) - Sucesso ao atualizar
     */
    @PUT
    public Response atualizar(Pessoa pessoa) {
        try {
            pessoaServico.atualizar(pessoa);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO ATUALIZAR PESSOA").build();
        }
        return Response.status(Status.OK).entity("SUCESSO AO ATUALIZAR PESSOA").build();
    }

    /**
     * Remove uma Pessoa do cadastro
     *
     * @param id: id da pessoa
     * @return response 200 (OK) - Sucesso ao remover
     */
    @DELETE
    @Path("id/{id}")
    public Response remover(@PathParam("id") Long id) {
        try {
            pessoaServico.remover(id);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO REMOVER PESSOA").build();
        }
        return Response.status(Status.OK).entity("SUCESSO AO REMOVER PESSOA").build();
    }
}
