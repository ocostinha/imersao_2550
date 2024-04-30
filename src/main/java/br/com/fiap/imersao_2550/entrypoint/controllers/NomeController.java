package br.com.fiap.imersao_2550.entrypoint.controllers;

import br.com.fiap.imersao_2550.core.business.NomeBusiness;
import br.com.fiap.imersao_2550.core.domain.Nome;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.ContratoEntradaDTO;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.ContratoSaidaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/nome")
public class NomeController {
    @Autowired
    private NomeBusiness business;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoSaidaDTO cadastrar(@Valid @RequestBody ContratoEntradaDTO dto) {
        return new ContratoSaidaDTO(
                business.cadatrar(
                        new Nome(dto)
                )
        );
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ContratoSaidaDTO> consultarTodos() {
        List<ContratoSaidaDTO> saida = new ArrayList<>();

        List<Nome> nomes = business.consultarTodos();

        nomes.forEach(nome -> {
            saida.add(new ContratoSaidaDTO(nome));
        });

        return saida;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ContratoSaidaDTO consultarPorId(@PathVariable Long id) {
        return new ContratoSaidaDTO(business.consultarPorId(id));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContratoSaidaDTO atualizarSobrenome(@PathVariable Long id, @RequestParam String sobrenome) {
        return new ContratoSaidaDTO(business.atualizarSobrenome(id, sobrenome));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContratoSaidaDTO sobrescreverRegistro(
            @PathVariable Long id,
            @Valid @RequestBody ContratoEntradaDTO contratoEntradaDTO
    ) {
        return new ContratoSaidaDTO(business.sobrescreverRegistro(id, new Nome(contratoEntradaDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletar(@PathVariable Long id) {
        business.deletar(id);
    }
}
