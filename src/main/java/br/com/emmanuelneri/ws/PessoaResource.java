package br.com.emmanuelneri.ws;

import br.com.emmanuelneri.model.Pessoa;
import br.com.emmanuelneri.service.PessoaService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Named
@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @GET
    @Path("listar")
    public List<Pessoa> listarPessoas() {
        return pessoaService.findAll();
    }
}
