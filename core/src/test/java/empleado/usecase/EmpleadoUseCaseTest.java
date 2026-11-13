package empleado.usecase;

import empleado.exception.*;
import empleado.modelo.Empleado;
import empleado.modelo.Puesto;
import empleado.output.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmpleadoUseCaseTest {
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoUseCase UseCase;

    @Test
    void debeLanzarExcepcionCuandoElLegajoYaExisteAlCrear() {
        UUID id = UUID.randomUUID();
        String nombre = "Juan Pérez";
        String legajo = "ABC1234";
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 15);
        Puesto puesto = Puesto.ANALISTA;
        Double salario = 500000.0;

        when(empleadoRepository.existeLegajo(legajo)).thenReturn(false);
        when(empleadoRepository.save(any(Empleado.class))).thenAnswer(i -> i.getArgument(0));

        Empleado empleado = UseCase.ejecutar(id, nombre, legajo, fechaIngreso, puesto, salario);

        assertNotNull(empleado);
        assertEquals("Juan Pérez", empleado.getNombre());
        assertEquals(legajo, empleado.getLegajo());
        verify(empleadoRepository, times(1)).existeLegajo(legajo);
        verify(empleadoRepository, times(1)).save(any(Empleado.class));
    }

    @Test
    void debeLanzarExcepcionSiLegajoYaExiste() {
        UUID id = UUID.randomUUID();
        String nombre = "Juan Pérez";
        String legajo = "ABC1234";
        LocalDate fechaIngreso = LocalDate.of(2020, 1, 15);
        Puesto puesto = Puesto.ANALISTA;
        Double salario = 500000.0;

        when(empleadoRepository.existeLegajo(legajo)).thenReturn(true);

        assertThrows(EmpleadoDuplicadoException.class, () -> {
            UseCase.ejecutar(id, nombre, legajo, fechaIngreso, puesto, salario);
        });

        verify(empleadoRepository, never()).save(any(Empleado.class));
    }
}
