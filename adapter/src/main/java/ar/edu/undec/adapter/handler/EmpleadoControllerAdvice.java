package ar.edu.undec.adapter.handler;

import empleado.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmpleadoControllerAdvice {

    @ExceptionHandler(EmpleadoNoEncontradoException.class)
    public ResponseEntity<String> handleEmpleadoNoEncontrado(EmpleadoNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EmpleadoDuplicadoException.class)
    public ResponseEntity<String> handleEmpleadoDuplicado(EmpleadoDuplicadoException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler({
            IdEmpleadoInvalidoException.class,
            NombreInvalidoException.class,
            LegajoInvalidoException.class,
            FechaIngresoInvalidaException.class,
            PuestoInvalidoException.class,
            SalarioInvalidoException.class
    })
    public ResponseEntity<String> handleValidacionesCore(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}