package uce.edu.web.api.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.application.representation.PacientesRepresentation;
import uce.edu.web.api.domain.Pacientes;
import uce.edu.web.api.infraestructure.PacientesRepository;

@ApplicationScoped
@Transactional
public class PacientesService {
    @Inject
    PacientesRepository pacientesRepository;
    public Pacientes mappToPR (PacientesRepresentation pr){
        Pacientes p = new Pacientes();
        p.id = pr.id;
        p.nombre = pr.nombre;
        p.apellido = pr.apellido;
        p.fechaNacimiento = java.time.LocalDate.parse(pr.fechaNacimiento);
        p.direccion = pr.direccion;
        return p;
    }
    public PacientesRepresentation mappToPR (Pacientes p){
        PacientesRepresentation pr = new PacientesRepresentation();
        pr.id = p.id;
        pr.nombre = p.nombre;
        pr.apellido = p.apellido;
        pr.fechaNacimiento = p.fechaNacimiento.toString();
        pr.direccion = p.direccion;
        return pr;
    }

    public List<PacientesRepresentation> ListarTodos(){
        List<PacientesRepresentation> p = new ArrayList<>();
        for(Pacientes paciente : pacientesRepository.listAll()){
            p.add(mappToPR(paciente));
        }
        return p;
    }
    public PacientesRepresentation BuscarPorId(Integer id){
        Pacientes p = pacientesRepository.findById(id.longValue());
        if(p == null){
            throw new RuntimeException("Paciente no encontrado");
        }
        return mappToPR(p);
    }
    public void Guardar(PacientesRepresentation pr){
        this.pacientesRepository.persist(mappToPR(pr));
    }
}
