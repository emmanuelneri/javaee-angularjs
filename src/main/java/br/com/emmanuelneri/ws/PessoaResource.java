package br.com.emmanuelneri.ws;

import br.com.emmanuelneri.model.Pessoa;
import br.com.emmanuelneri.service.PessoaService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Named
@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @GET
    @Path("listar")
    public List<Pessoa> listarPessoas() {
        return pessoaService.findAll();
    }

    @POST
    @Path("cadastrar")
    public Response salvar(@Valid Pessoa pessoa) {
        pessoaService.save(pessoa);
        return Response.ok().build();
    }
}
