package br.com.fiap.imersao_2550;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nome")
public class NomeController {
    @Autowired
    private NomeRepository nomeRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ContratoSaida> cadastrar(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        return ResponseEntity.status(201).body(
                new ContratoSaida(nomeRepository.save(new NomeEntity(contratoEntrada)))
        );
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ContratoSaida> consultarTodos(){
        List<ContratoSaida> saida = new ArrayList<>();

        List<NomeEntity> nomes = nomeRepository.findAll();

        if (nomes.isEmpty()) {
            throw new NotFoundException();
        }

        nomes.forEach(nome -> {
            saida.add(new ContratoSaida(nome.getId(), nome.getNomeCompleto()));
        });

        return saida;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ContratoSaida consultarPorId(@PathVariable Long id){
        return new ContratoSaida(consultarPorId(id, false));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContratoSaida atualizarSobrenome(@PathVariable Long id, @RequestParam String sobrenome){
        NomeEntity entity = consultarPorId(id, true);

        entity.setNomeCompleto(entity.getNome(), sobrenome);

        return new ContratoSaida(nomeRepository.save(entity));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContratoSaida sobrescreverRegistro(
            @PathVariable Long id,
            @Valid @RequestBody ContratoEntrada contratoEntrada
    ) {
        NomeEntity entity = consultarPorId(id, true);
        entity.setNomeCompleto(contratoEntrada);

        return new ContratoSaida(nomeRepository.save(entity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletar(@PathVariable Long id){
        nomeRepository.delete(
                consultarPorId(id, true)
        );
    }

    private NomeEntity consultarPorId(Long id, Boolean regraDeNegocio) {
        Optional<NomeEntity> entity = nomeRepository.findById(id);

        if (entity.isEmpty()) {
            if (regraDeNegocio) {
                throw new NomeNaoEncontradoException();
            } else {
                throw new NotFoundException();
            }
        }

        return entity.get();
    }
}
