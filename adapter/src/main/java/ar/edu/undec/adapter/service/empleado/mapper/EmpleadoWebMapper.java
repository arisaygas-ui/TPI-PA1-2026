package ar.edu.undec.adapter.service.empleado.mapper;

import empleado.modelo.Empleado;
import ar.edu.undec.adapter.service.empleado.model.EmpleadoDTO;
public class EmpleadoWebMapper {

    public static EmpleadoDTO aDTO(Empleado empleado) {
        if (empleado == null) {
            return null;
        }
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setLegajo(empleado.getLegajo());
        dto.setFechaIngreso(empleado.getFechaIngreso());
        dto.setPuesto(empleado.getPuesto() != null ? empleado.getPuesto().name() : null);
        dto.setSalario(empleado.getSalario());
        return dto;
    }
}
