package br.com.marketplace.controllers;

import br.com.marketplace.models.Avalia;
import br.com.marketplace.models.Profissional;
import br.com.marketplace.services.AvaliaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/contrata")
public class AvaliaController {

    private final AvaliaService avaliaService;

    public AvaliaController(AvaliaService avaliaService) {
    this.avaliaService = avaliaService;
    }


    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Avalia avalia, UriComponentsBuilder builder){
            Avalia aux = this.avaliaService.criar(avalia);
            var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
            return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping({"{/id}"})
    public ResponseEntity buscar(@PathVariable Long id){
        Avalia aux = this.avaliaService.buscarPorId(id);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Avalia avalia, @PathVariable Long id){
        var aux = avaliaService.atualizar(id, avalia);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping({"{/id}"})
    public ResponseEntity deletar(@PathVariable Long id){
        this.avaliaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
