package br.com.fiap.imersao_2550.commons.exceptions.advisor;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import br.com.fiap.imersao_2550.commons.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.imersao_2550.commons.exceptions.advisor.dto.ErroSaidaDTO;
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

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<ErroSaidaDTO> handleValidationExceptions(RegistroNaoEncontradoException ex) {
        return ResponseEntity.status(422).body(new ErroSaidaDTO("Registro não encontrado para realizar alterações"));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroSaidaDTO handleMissingParams(MissingServletRequestParameterException ex) {
        return new ErroSaidaDTO(ex.getParameterName() + " não pode ser nulo");
    }
}
