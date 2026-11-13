package ar.edu.undec.adapter.data.empleado;

import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import ar.edu.undec.adapter.data.empleado.mapper.EmpleadoMapper;
import empleado.modelo.Empleado;
import empleado.modelo.Puesto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoMapperTest {
    @Test
    void mapearATablaEmpleadoValidoRetornaEntityCorrecta() {
        UUID id = UUID.randomUUID();
        Empleado empleado = Empleado.newEmpleado(id, "Juan Pérez", "ABC1234", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);

        EmpleadoEntity entity = EmpleadoMapper.mapearATabla(empleado);

        assertNotNull(entity);
        assertEquals(empleado.getId(), entity.getId());
        assertEquals(empleado.getNombre(), entity.getNombre());
        assertEquals(empleado.getLegajo(), entity.getLegajo());
        assertEquals(empleado.getFechaIngreso(), entity.getFechaIngreso());
        assertEquals(empleado.getPuesto(), entity.getPuesto());
        assertEquals(empleado.getSalario(), entity.getSalario());
    }
}