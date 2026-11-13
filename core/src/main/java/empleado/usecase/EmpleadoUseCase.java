package empleado.usecase;

import empleado.exception.EmpleadoDuplicadoException;
import empleado.modelo.Empleado;
import empleado.modelo.Puesto;
import empleado.output.EmpleadoRepository;

import java.time.LocalDate;
import java.util.UUID;

public class EmpleadoUseCase {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoUseCase(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado ejecutar(UUID id, String nombre, String legajo, LocalDate fechaIngreso, Puesto puesto, Double salario) {
        if (empleadoRepository.existeLegajo(legajo)) {
            throw new EmpleadoDuplicadoException("El empleado con legajo ya existe: " + legajo);
        }
        Empleado empleado = Empleado.newEmpleado(id, nombre, legajo, fechaIngreso, puesto, salario);

        return empleadoRepository.save(empleado);
    }
}
