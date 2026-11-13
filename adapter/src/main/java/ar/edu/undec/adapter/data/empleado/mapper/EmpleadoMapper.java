package ar.edu.undec.adapter.data.empleado.mapper;

import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import empleado.modelo.Empleado;

public class EmpleadoMapper {
    public static EmpleadoEntity mapearATabla(Empleado empleado) {
        if(empleado == null) {
            return null;
        }
        return new EmpleadoEntity(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getLegajo(),
                empleado.getFechaIngreso(),
                empleado.getPuesto(),
                empleado.getSalario()
        );
    }

    public static Empleado mapearADominio(EmpleadoEntity entity) {
        if(entity == null) {
            return null;
        }
        return new Empleado(
                entity.getId(),
                entity.getNombre(),
                entity.getLegajo(),
                entity.getFechaIngreso(),
                entity.getPuesto(),
                entity.getSalario()
        );
    }
}
