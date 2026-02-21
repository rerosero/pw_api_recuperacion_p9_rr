package uce.edu.web.api.interfaces;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.application.PacientesService;
import uce.edu.web.api.application.representation.PacientesRepresentation;

@Path("/pacientes")
public class PacientesResource {
    @Inject
    PacientesService pacientesService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    @RolesAllowed("admin")
    public List<PacientesRepresentation> ListarTodos(){
        return pacientesService.ListarTodos();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("admin")
    public PacientesRepresentation buscarId( @PathParam("id") Integer id){
        return pacientesService.BuscarPorId(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    @RolesAllowed("admin")
    public Response Guardar(PacientesRepresentation pr){
        this.pacientesService.Guardar(pr);
        return Response.ok().entity(pr).build();
    }
    



}
