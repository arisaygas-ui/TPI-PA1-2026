package empleado.usecase;

import empleado.exception.EmpleadoNoEncontradoException;
import empleado.modelo.Empleado;
import empleado.output.EmpleadoRepository;
import java.util.Optional;

public class BuscarEmpleadoPorLegajoUseCase {
    private final EmpleadoRepository empleadoRepository;

    public BuscarEmpleadoPorLegajoUseCase(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado ejecutar(String legajo) {
        return empleadoRepository.buscarPorLegajo(legajo)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado con legajo " + legajo + " no encontrado"));
    }
}
