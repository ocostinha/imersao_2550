package br.com.fiap.imersao_2550;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleValidationExceptions(NotFoundException ex) {
        return ResponseEntity.status(204).build();
    }

    @ExceptionHandler(NomeNaoEncontradoException.class)
    public ResponseEntity<ErroSaida> handleValidationExceptions(NomeNaoEncontradoException ex) {
        return ResponseEntity.status(422).body(new ErroSaida("Nome não encontrado para realizar alterações"));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroSaida handleMissingParams(MissingServletRequestParameterException ex) {
        return new ErroSaida(ex.getParameterName() + " não pode ser nulo");
    }
}
