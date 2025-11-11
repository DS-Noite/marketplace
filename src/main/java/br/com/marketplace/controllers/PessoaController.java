package br.com.marketplace.controllers;

import br.com.marketplace.models.Pessoa;
import br.com.marketplace.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Pessoa pessoa, UriComponentsBuilder builder){
        Pessoa aux = this.pessoaService.criar(pessoa);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var aux = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id){
        var aux = pessoaService.atualizar(id,pessoa);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
