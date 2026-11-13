package ar.edu.undec.adapter.data.empleado.repoimplementacion;

import ar.edu.undec.adapter.data.empleado.crud.IEmpleadoJPARepository;
import ar.edu.undec.adapter.data.empleado.mapper.EmpleadoMapper;
import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import empleado.output.EmpleadoRepository;
import empleado.modelo.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmpleadoRepositorioImpl implements EmpleadoRepository {

    private final IEmpleadoJPARepository empleadoJPARepository;

    @Autowired
    public EmpleadoRepositorioImpl(IEmpleadoJPARepository empleadoJPARepository) {
        this.empleadoJPARepository = empleadoJPARepository;
    }

    @Override
    public Empleado save(Empleado empleado) {
        EmpleadoEntity entity = EmpleadoMapper.mapearATabla(empleado);
        EmpleadoEntity savedEntity = empleadoJPARepository.save(entity);
        return EmpleadoMapper.mapearADominio(savedEntity);
    }


    @Override
    public Optional<Empleado> buscarPorLegajo(String legajo) {
        Optional<EmpleadoEntity> entityOpt = empleadoJPARepository.findByLegajo(legajo);
        return entityOpt.map(EmpleadoMapper::mapearADominio);
    }

    @Override
    public boolean existeLegajo(String legajo) {
        return empleadoJPARepository.findByLegajo(legajo).isPresent();
    }
}
