package ar.edu.undec.adapter.service.empleado.beanconfig;

import empleado.output.EmpleadoRepository;
import empleado.usecase.BuscarEmpleadoPorLegajoUseCase;
import empleado.usecase.EmpleadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public EmpleadoUseCase empleadoUseCase(EmpleadoRepository empleadoRepository) {
        return new EmpleadoUseCase(empleadoRepository);
    }

    @Bean
    public BuscarEmpleadoPorLegajoUseCase buscarEmpleadoPorLegajoUseCase(EmpleadoRepository empleadoRepository) {
        return new BuscarEmpleadoPorLegajoUseCase(empleadoRepository);
    }
}