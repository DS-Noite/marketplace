package br.com.marketplace.controllers;

import br.com.marketplace.models.Contrata;
import br.com.marketplace.services.ContrataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/contrata")
public class ContrataController {

    private final ContrataService contrataService;

    public ContrataController(ContrataService contrataService) {
        this.contrataService = contrataService;
    }

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Contrata contrata, UriComponentsBuilder builder){
        Contrata aux = this.contrataService.criar(contrata);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var aux = contrataService.buscarPorId(id);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Contrata contrata, @PathVariable Long id){
        var aux = contrataService.atualizar(id, contrata);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        contrataService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
