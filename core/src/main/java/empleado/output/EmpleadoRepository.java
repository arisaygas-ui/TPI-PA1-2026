package empleado.output;

import empleado.modelo.Empleado;
import java.util.Optional;

public interface EmpleadoRepository {
    boolean existeLegajo(String legajo);

    Empleado save(Empleado empleado);

    Optional<Empleado> buscarPorLegajo(String legajo);
}
