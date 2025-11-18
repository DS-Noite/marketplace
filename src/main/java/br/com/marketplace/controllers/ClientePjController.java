package br.com.marketplace.controllers;


import br.com.marketplace.models.Cliente;
import br.com.marketplace.models.ClientePJ;
import br.com.marketplace.services.ClientePjService;
import br.com.marketplace.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/clientePj")
public class ClientePjController {

    private final ClientePjService clientePjService;

    public ClientePjController(ClientePjService clientePjService){
        this.clientePjService = clientePjService;
    }

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody ClientePJ clientePj, UriComponentsBuilder builder){
        ClientePJ aux = this.clientePjService.criar(clientePj);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable String cnpj){
        var aux = clientePjService.buscarPorId(cnpj);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody ClientePJ clientePJ, @PathVariable String cnpj) {
        var aux = clientePjService.atualizar(cnpj, clientePJ);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable String cnpj){
        clientePjService.deletar(cnpj);
        return  ResponseEntity.noContent().build();
    }
}
