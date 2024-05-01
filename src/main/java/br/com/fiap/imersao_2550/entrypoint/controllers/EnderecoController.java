package br.com.fiap.imersao_2550.entrypoint.controllers;

import br.com.fiap.imersao_2550.commons.mappers.EnderecoMapper;
import br.com.fiap.imersao_2550.core.business.EnderecoBusiness;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.EnderecoEntradaDTO;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.EnderecoSaidaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoBusiness business;

    @Autowired
    private EnderecoMapper mapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoSaidaDTO cadastrar(@Valid @RequestBody EnderecoEntradaDTO dto) {
        return mapper.toSaida(business.cadatrar(mapper.toDomain(dto)));
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<EnderecoSaidaDTO> consultarTodos() {
        return mapper.toSaida(business.consultarTodos());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EnderecoSaidaDTO consultarPorId(@PathVariable Long id) {
        return mapper.toSaida(business.consultarPorId(id));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EnderecoSaidaDTO atualizarLogradouro(@PathVariable Long id, @RequestParam String logradouro) {
        return mapper.toSaida(business.atualizarLogradouro(id, logradouro));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EnderecoSaidaDTO sobrescreverRegistro(
            @PathVariable Long id,
            @Valid @RequestBody EnderecoEntradaDTO dto
    ) {
        return mapper.toSaida(business.sobrescreverRegistro(id, mapper.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletar(@PathVariable Long id) {
        business.deletar(id);
    }
}
