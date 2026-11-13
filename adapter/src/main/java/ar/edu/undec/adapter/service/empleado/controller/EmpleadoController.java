package ar.edu.undec.adapter.service.empleado.controller;

import empleado.modelo.Empleado;
import empleado.modelo.Puesto;
import empleado.usecase.BuscarEmpleadoPorLegajoUseCase;
import empleado.usecase.EmpleadoUseCase;
import ar.edu.undec.adapter.service.empleado.model.EmpleadoDTO;
import ar.edu.undec.adapter.service.empleado.mapper.EmpleadoWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoUseCase empleadoUseCase;
    private final BuscarEmpleadoPorLegajoUseCase buscarEmpleadoPorLegajoUseCase;

    public EmpleadoController(EmpleadoUseCase empleadoUseCase, BuscarEmpleadoPorLegajoUseCase buscarEmpleadoPorLegajoUseCase) {
        this.empleadoUseCase = empleadoUseCase;
        this.buscarEmpleadoPorLegajoUseCase = buscarEmpleadoPorLegajoUseCase;
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO dto) {
        Puesto puestoEnum = null;
        if (dto.getPuesto() != null && !dto.getPuesto().isBlank()) {
            puestoEnum = Puesto.valueOf(dto.getPuesto());
        }

        Empleado empleado = empleadoUseCase.ejecutar(
                dto.getId(),
                dto.getNombre(),
                dto.getLegajo(),
                dto.getFechaIngreso(),
                puestoEnum,
                dto.getSalario()
        );

        EmpleadoDTO responseDto = EmpleadoWebMapper.aDTO(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{legajo}")
    public ResponseEntity<EmpleadoDTO> buscarPorLegajo(@PathVariable String legajo) {
        Empleado empleado = buscarEmpleadoPorLegajoUseCase.ejecutar(legajo);
        EmpleadoDTO responseDto = EmpleadoWebMapper.aDTO(empleado);
        return ResponseEntity.ok(responseDto);
    }
}
