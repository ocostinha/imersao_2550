package br.com.fiap.imersao_2550.entrypoint.controllers;

import br.com.fiap.imersao_2550.commons.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/primeira_chamada")
public class PrimeiraChamadaRESTController {
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> primeiraChamada() {
        throw new NotFoundException();
    }
}
