package com.stefanini.resource;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PessoaResourceTest extends TestCase {

    private static WebTarget service;
    private static final String URL_LOCAL = "http://localhost:8080/treinamento/api/pessoas";

    @Inject
    private PessoaResource pessoaResource;

    @InjectMocks
    private PessoaServico pessoaServico;

    @Mock
    private PessoaDao pessoaDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public static void setUpBeforeClass() throws Exception {
        Client client = ClientBuilder.newClient();
        service = client.target(UriBuilder.fromUri(URL_LOCAL).build());
    }

    @Test
    public void testListaTodosPessoas() {
        PessoaResource pessoaResource = new PessoaResource();
        assertTrue(pessoaResource.obterTodos().getStatusInfo().equals(Response.Status.INTERNAL_SERVER_ERROR));
        System.out.println(pessoaResource.obterTodos().getStatus());
    }

    @Test
    public void testRemovePessoa() {
        // QUANDO
        PessoaResource pessoaResource = new PessoaResource();
        Pessoa removePessoa = new Pessoa();
        removePessoa.setId(22L);
        // ENTAO
        assertFalse(pessoaResource.remover(removePessoa.getId()).getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode());
        System.out.println(pessoaResource.remover(removePessoa.getId()).getStatus());
    }

    @Test
    public void testAtualizaPessoa() {
        // QUANDO
        PessoaResource pessoaResource = new PessoaResource();
        Pessoa atualizaPessoa = new Pessoa();
        atualizaPessoa.setId(25L);
        atualizaPessoa.setNome("Dernival Liandro");
        atualizaPessoa.setEmail("liandro@gmail.com");
        atualizaPessoa.setDataNascimento(LocalDate.parse("1991-05-14"));
        atualizaPessoa.setSituacao(true);
        // ENTAO
        assertFalse(pessoaResource.atualizar(atualizaPessoa).getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode());
        System.out.println(pessoaResource.atualizar(atualizaPessoa).getStatus());
    }

    @Test
    public void testInsereNovaPessoa() {
        // QUANDO
        PessoaResource pessoaResource = new PessoaResource();
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome("Dernival Liandro");
        novaPessoa.setEmail("liandro@gmail.com");
        novaPessoa.setDataNascimento(LocalDate.parse("1991-05-14"));
        novaPessoa.setSituacao(true);
        // ENTAO
        assertFalse(pessoaResource.salvar(novaPessoa).getStatusInfo().getStatusCode() == Response.Status.CREATED.getStatusCode());
        System.out.println(pessoaResource.salvar(novaPessoa).getStatus());
    }

}
