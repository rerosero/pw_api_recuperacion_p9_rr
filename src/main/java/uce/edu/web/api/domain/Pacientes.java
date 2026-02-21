package uce.edu.web.api.domain;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="pacientes")
@SequenceGenerator(name="seq_pacientes", sequenceName = "seq_pacientes", allocationSize = 1)
public class Pacientes extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pacientes")
    public Integer id;
    public String nombre;
    public String apellido;
    public LocalDate fechaNacimiento;
    public String direccion;
}
