package empleado.usecase;

import empleado.exception.EmpleadoNoEncontradoException;
import empleado.modelo.Empleado;
import empleado.modelo.Puesto;
import empleado.output.EmpleadoRepository;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscarEmpleadoPorLegajoUseCaseTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private BuscarEmpleadoPorLegajoUseCase UseCase;

    @Test
    void debeBuscarEmpleadoPorLegajoExitosamente() {
        String legajo = "ABC1234";
        UUID id = UUID.randomUUID();
        Empleado empleado = Empleado.newEmpleado(id, "Juan Pérez", legajo, LocalDate.of(2020, 1, 15), Puesto.ANALISTA, 500000.0);
        when(empleadoRepository.buscarPorLegajo(legajo)).thenReturn(Optional.of(empleado));

        Empleado resultado = UseCase.ejecutar(legajo);

        assertNotNull(resultado);
        assertEquals(legajo, resultado.getLegajo());
        verify(empleadoRepository, times(1)).buscarPorLegajo(legajo);
    }

    @Test
    void debeLanzarExcepcionSiEmpleadoNoExiste() {
        String legajoInexistente = "ABC0000";
        when(empleadoRepository.buscarPorLegajo(legajoInexistente)).thenReturn(Optional.empty());

        assertThrows(EmpleadoNoEncontradoException.class, () -> {
            UseCase.ejecutar(legajoInexistente);
        });

        verify(empleadoRepository, times(1)).buscarPorLegajo(legajoInexistente);
    }
}
