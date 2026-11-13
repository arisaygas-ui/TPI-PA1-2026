package ar.edu.undec.adapter.data.empleado.crud;

import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEmpleadoJPARepository extends JpaRepository<EmpleadoEntity, UUID> {
    Optional<EmpleadoEntity> findByLegajo(String legajo);
}
