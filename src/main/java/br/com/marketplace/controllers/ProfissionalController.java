package br.com.marketplace.controllers;

import br.com.marketplace.models.Profissional;
import br.com.marketplace.services.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({"/api/profissional"})

public class ProfissionalController {
    private final ProfissionalService profissionalService;


    public ProfissionalController(ProfissionalService profissionalService){
        this.profissionalService = profissionalService;}

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Profissional profissional, UriComponentsBuilder builder) {
        Profissional aux = this.profissionalService.criar(profissional);
        var uri = builder.path("/{id}").buildAndExpand(aux.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping({"{/id}"})
    public ResponseEntity buscar(@PathVariable String cnpj){
        Profissional aux = this.profissionalService.buscarPorId(cnpj);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Profissional profissional, @PathVariable String cnpj){
        var aux = profissionalService.atualizar(cnpj, profissional);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping({"{/id}"})
    public ResponseEntity deletar(@PathVariable String cnpj){
        this.profissionalService.deletar(cnpj);
        return ResponseEntity.noContent().build();

    }
}