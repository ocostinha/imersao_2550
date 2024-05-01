package br.com.fiap.imersao_2550.entrypoint.controllers;

import br.com.fiap.imersao_2550.commons.mappers.TelefoneMapper;
import br.com.fiap.imersao_2550.core.business.TelefoneBusiness;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.TelefoneEntradaDTO;
import br.com.fiap.imersao_2550.entrypoint.controllers.dto.TelefoneSaidaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneBusiness business;

    @Autowired
    private TelefoneMapper mapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public TelefoneSaidaDTO cadastrar(@Valid @RequestBody TelefoneEntradaDTO dto) {
        return mapper.toSaida(business.cadatrar(mapper.toDomain(dto)));
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TelefoneSaidaDTO> consultarTodos() {
        return mapper.toSaida(business.consultarTodos());
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TelefoneSaidaDTO consultarPorId(@PathVariable Long id) {
        return mapper.toSaida(business.consultarPorId(id));
    }

    @PatchMapping("/{id}/celular")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TelefoneSaidaDTO atualizarCelular(
            @PathVariable Long id,
            @RequestParam Long dddCelular,
            @RequestParam Long celular
    ) {
        return mapper.toSaida(business.atualizarCelular(id, dddCelular, celular));
    }

    @PatchMapping("/{id}/fixo")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TelefoneSaidaDTO atualizarFixo(
            @PathVariable Long id,
            @RequestParam Long dddFixo,
            @RequestParam Long fixo
    ) {
        return mapper.toSaida(business.atualizarFixo(id, dddFixo, fixo));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TelefoneSaidaDTO sobrescreverRegistro(
            @PathVariable Long id,
            @Valid @RequestBody TelefoneEntradaDTO dto
    ) {
        return mapper.toSaida(business.sobrescreverRegistro(id, mapper.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletar(@PathVariable Long id) {
        business.deletar(id);
    }
}
