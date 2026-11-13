package ar.edu.undec.adapter.service.empleado.model;

import java.time.LocalDate;
import java.util.UUID;

public class EmpleadoDTO {
    private UUID id;
    private String nombre;
    private String legajo;
    private LocalDate fechaIngreso;
    private String puesto;
    private Double salario;

    public EmpleadoDTO() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getLegajo() { return legajo; }
    public void setLegajo(String legajo) { this.legajo = legajo; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
}