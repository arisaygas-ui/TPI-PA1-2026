package ar.edu.undec.adapter.data.empleado;

import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import ar.edu.undec.adapter.data.empleado.repository.IEmpleadoJPARepository;
import empleado.modelo.Puesto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmpleadoRepositoryTest {
    @Autowired
    private IEmpleadoJPARepository empleadoJPARepository;

    @Test
    void debeGuardarYBuscarPorLegajoEmpleadoValidoYRetornaEmpleadoGuardado() {
        UUID id = UUID.randomUUID();
        EmpleadoEntity entity = new EmpleadoEntity(id, "Juan Perez", "ABC1234", LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);

        empleadoJPARepository.save(entity);
        Optional<EmpleadoEntity> encontrado = empleadoJPARepository.findByLegajo("ABC1234");

        assertTrue(encontrado.isPresent());
        assertEquals("Juan Perez", encontrado.get().getNombre());
        assertEquals("ABC1234", encontrado.get().getLegajo());

    }
}
