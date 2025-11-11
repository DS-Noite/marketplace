package br.com.marketplace.controllers;


import br.com.marketplace.models.Servico;
import br.com.marketplace.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({"/api/servico"})

public class ServicoController {
    public final ServicoService servicoService;

    public ServicoController(ServicoService servicoService){this.servicoService = servicoService;}

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Servico servico, UriComponentsBuilder builder) {
        Servico aux = this.servicoService.criar(servico);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping({"/{id}"})
    public ResponseEntity buscar(@PathVariable Long id){
        Servico aux = this.servicoService.buscarPorId(id);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Servico servico, @PathVariable Long id){
        var aux = servicoService.atualizar(id,servico);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping({"/{id}"})
    public ResponseEntity deletar(@PathVariable Long id) {
        this.servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}