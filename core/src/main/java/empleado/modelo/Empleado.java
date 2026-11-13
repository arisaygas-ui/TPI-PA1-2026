package empleado.modelo;

import empleado.exception.*;
import java.time.LocalDate;
import java.util.UUID;

public class Empleado {

    private UUID id;
    private String nombre;
    private String legajo;
    private LocalDate fechaIngreso;
    private Puesto puesto;
    private Double salario;

    public Empleado(UUID id, String nombre, String legajo, LocalDate fechaIngreso, Puesto puesto, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;
    }

    public static Empleado newEmpleado(UUID id, String nombre, String legajo, LocalDate fechaIngreso, Puesto puesto, Double salario) {
        if (id == null) {
            throw new IdEmpleadoInvalidoException("El ID del empleado es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new NombreInvalidoException("El nombre del empleado es obligatorio");
        }
        if (legajo == null || legajo.isBlank()) {
            throw new LegajoInvalidoException("El legajo del empleado es obligatorio");
        }
        if (fechaIngreso == null) {
            throw new FechaIngresoInvalidaException("La fecha de ingreso del empleado es obligatoria");
        }
        if (puesto == null) {
            throw new PuestoInvalidoException("El puesto del empleado no puede ser nulo");
        }
        if (salario == null || salario <= 0) {
            throw new SalarioInvalidoException("El salario del empleado no puede ser negativo ni cero");
        }

        if(!legajo.matches("^[A-Z]{3}\\d{4}$")) {
            throw new LegajoInvalidoException("El legajo del empleado debe tener el formato correcto (3 letras mayúsculas seguidas de 4 dígitos)");
        }
        if(fechaIngreso.isAfter(LocalDate.now())) {
            throw new FechaIngresoInvalidaException("La fecha de ingreso del empleado no puede ser futura");
        }

        double pisoMinimo =0.0;
        if(puesto == Puesto.ANALISTA){
            pisoMinimo = 500000.0;
        } else if(puesto == Puesto.SUPERVISOR){
            pisoMinimo = 800000.0;
        } else if(puesto == Puesto.GERENTE){
            pisoMinimo = 1200000.0;
        }

        if(salario < pisoMinimo){
            throw new SalarioInvalidoException("El salario del empleado no puede ser menor al piso mínimo para su puesto");
        }
        return new Empleado(id, nombre, legajo, fechaIngreso, puesto, salario);
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getLegajo() { return legajo; }
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public Puesto getPuesto() { return puesto; }
    public double getSalario() { return salario; }
}
