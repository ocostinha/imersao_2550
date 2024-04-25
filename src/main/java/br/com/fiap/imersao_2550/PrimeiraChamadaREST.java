package br.com.fiap.imersao_2550;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/primeira_chamada")
public class PrimeiraChamadaREST {
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> primeiraChamada() {
        return ResponseEntity.ok("Minha primeira chamada");
    }
}
