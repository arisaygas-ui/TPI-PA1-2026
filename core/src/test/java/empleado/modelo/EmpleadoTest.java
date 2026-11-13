package empleado.modelo;

import empleado.exception.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    @Test
    void debeCrearEmpleadoValido(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 15);
        Puesto puesto = Puesto.ANALISTA;
        double salario = 500000.0;

        Empleado empleado = Empleado.newEmpleado(id, nombre, legajo, fechaIngreso, puesto, salario);

        assertEquals(id, empleado.getId());
        assertEquals(nombre, empleado.getNombre());
        assertEquals(legajo, empleado.getLegajo());
        assertEquals(fechaIngreso, empleado.getFechaIngreso());
        assertEquals(puesto, empleado.getPuesto());
        assertEquals(salario, empleado.getSalario());
    }

    @Test
    void debeLanzarExcepcionSiIdEsNulo() {
        assertThrows(IdEmpleadoInvalidoException.class, () -> {
            Empleado.newEmpleado(null, "Juan Perez", "ABC1234", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);
        });
    }
    @Test
    void debeLanzarExcepcionSiNombreEsVacio() {
        UUID id = UUID.randomUUID();
        assertThrows(NombreInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "", "ABC1234", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiLegajoEsVacio() {
        UUID id = UUID.randomUUID();
        assertThrows(LegajoInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiFechaIngresoEsNula() {
        UUID id = UUID.randomUUID();
        assertThrows(FechaIngresoInvalidaException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "ABC1234", null, Puesto.ANALISTA, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiPuestoEsNulo() {
        UUID id = UUID.randomUUID();
        assertThrows(PuestoInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "ABC1234", LocalDate.of(2020, 1, 15), null, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiSalarioEsCero() {
        UUID id = UUID.randomUUID();
        assertThrows(SalarioInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "ABC1234", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 0.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiFechaIngresoEsFutura() {
        UUID id = UUID.randomUUID();
        LocalDate fechaIngreso = LocalDate.of(2030, 1 , 15);
        assertThrows(FechaIngresoInvalidaException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "ABC1234", fechaIngreso, Puesto.ANALISTA, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiLegajoNoCumpleFormato() {
        UUID id = UUID.randomUUID();
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 15);

        assertThrows(LegajoInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "1234ABC", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);
        });
    }

    @Test
    void debeLanzarExcepcionSiSalarioEsMenorAlPisoSalarial() {
        UUID id = UUID.randomUUID();
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 15);

        assertThrows(SalarioInvalidoException.class, () -> {
            Empleado.newEmpleado(id, "Juan Perez", "ABC1234", fechaIngreso, Puesto.ANALISTA, 450000.0);
        });
    }
}
