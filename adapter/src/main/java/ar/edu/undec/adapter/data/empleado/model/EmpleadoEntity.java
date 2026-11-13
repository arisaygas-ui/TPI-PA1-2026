package ar.edu.undec.adapter.data.empleado.model;

import empleado.modelo.Puesto;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "empleados")
public class EmpleadoEntity {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String legajo;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Puesto puesto;

    @Column(nullable = false)
    private double salario;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(UUID id, String nombre, String legajo, LocalDate fechaIngreso, Puesto puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;
    }

    public UUID getId() { return id;}
    public void setId(UUID id) { this.id = id;}

    public String getNombre() { return nombre;}
    public void setNombre(String nombre) { this.nombre = nombre;}

    public String getLegajo() { return legajo;}
    public void setLegajo(String legajo) { this.legajo = legajo;}

    public LocalDate getFechaIngreso() { return fechaIngreso;}
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso;}

    public Puesto getPuesto() { return puesto;}
    public void setPuesto(Puesto puesto) { this.puesto = puesto;}

    public double getSalario() { return salario;}
    public void setSalario(double salario) { this.salario = salario;}
}
