package br.com.fiap.imersao_2550;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/nome")
public class NomeController {
    @Autowired
    private NomeRepository nomeRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ContratoSaida> cadastrar(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        NomeEntity entity = new NomeEntity();
        entity.setNomeCompleto(contratoEntrada.getNome() + " " + contratoEntrada.getSobrenome());

        NomeEntity savedEntity = nomeRepository.save(entity);

        return ResponseEntity.status(201).body(
                new ContratoSaida(savedEntity.getId(), savedEntity.getNomeCompleto())
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
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
}
