package com.stefanini.resource;

import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.PessoaPerfilServico;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("pessoas-perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {

    @Inject
    private PessoaPerfilServico pessoaPerfilServico;

    /**
     * Adiciona novo vinculo de Pessoa ao Perfil
     *
     * @param pessoaPerfil: Novo pessoaPerfil
     * @return response 201 (CREATED) - Sucesso ao vincular
     */
    @POST
    public Response vincularPessoaPerfil(PessoaPerfil pessoaPerfil) {
        try {
            pessoaPerfilServico.salvar(pessoaPerfil);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO VINCULAR PESSOA AO PERFIL").build();
        }
        return Response.status(Status.CREATED.getStatusCode()).entity("SUCESSO AO VINCULAR A PESSOA AO PERFIL").build();
    }

    /**
     * Lista todos os vinculos de Pessoas com Perfis
     *
     * @return response 200 (OK) - Sucesso ao listar
     */
    @GET
    public Response obterTodosVinculosPessoaPerfil() {
        Response obterTodasVinculosPessoaPerfil = null;
        try {
            obterTodasVinculosPessoaPerfil = Response.ok(pessoaPerfilServico.getList().get()).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR LISTA DE VINCULOS ENTRE PESSOAS E SEUS PERFIS").build();
        }
        return obterTodasVinculosPessoaPerfil;
    }

    /**
     * Encontra um vinculo de Pessoa com Perfil utilizando a ID
     *
     * @param id: id da pessoaPerfil
     * @return response 200 (OK) - Sucesso ao obter vinculo Pessoa com Perfil
     */
    @GET
    @Path("id/{id}")
    public Response obterPorId(@PathParam("id") Long id) {
        Response obterTodasVinculosPessoaPerfilId = null;
        try {
            obterTodasVinculosPessoaPerfilId = Response.ok(pessoaPerfilServico.encontrar(id).get()).build();
            ;
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERRO AO BUSCAR VINCULOS DE PESSOAS E SEUS PERFIS, PELO ID").build();
        }
        return obterTodasVinculosPessoaPerfilId;
    }

    /**
     * Atualiza um vinculo de Pessoa com o Perfil
     *
     * @param pessoaPerfil: PessoaPerfil atualizado
     * @return response 200 (OK) - Sucesso ao atualizar
     */
    @PUT
    public Response atualizar(PessoaPerfil pessoaPerfil) {
        try {
            pessoaPerfilServico.atualizar(pessoaPerfil);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO ATUALIZAR VINCULO DE PESSOA COM O PERFIL").build();
        }
//        if ()
        return Response.status(Status.OK).entity("SUCESSO AO ATUALIZAR O VINCULO DE PESSOA COM O PERFIL").build();
    }

    /**
     * Remove um vinculo de Pessoa com Perfil
     *
     * @param id: id da pessoaPerfil
     * @return response 200 (OK) - Sucesso ao remover
     */
    @DELETE
    @Path("id/{id}")
    public Response remover(@PathParam("id") Long id) {
        try {
            pessoaPerfilServico.remover(id);
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity("ERRO AO REMOVER VINCULO DE PESSOA COM O PERFIL").build();
        }
        return Response.status(Status.OK).entity("SUCESSO AO REMOVER O VINCULO DE PESSOA COM O PERFIL").build();
    }
}
