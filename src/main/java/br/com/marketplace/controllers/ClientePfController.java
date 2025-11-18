package br.com.marketplace.controllers;


import br.com.marketplace.models.Cliente;
import br.com.marketplace.models.ClientePF;
import br.com.marketplace.models.ClientePJ;
import br.com.marketplace.services.ClientePfService;
import br.com.marketplace.services.ClientePjService;
import br.com.marketplace.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/clientePf")
public class ClientePfController {

    private final ClientePfService clientePfService;

    public ClientePfController(ClientePfService clientePfService){
        this.clientePfService = clientePfService;
    }

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody ClientePF clientePf, UriComponentsBuilder builder){
        ClientePF aux = this.clientePfService.criar(clientePf);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable String cpf){
        var aux = clientePfService.buscarPorId(cpf);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody ClientePF clientePF, @PathVariable String cpf) {
        var aux = clientePfService.atualizar(cpf, clientePF);
        return ResponseEntity.ok(aux);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable String cpf){
        clientePfService.deletar(cpf);
        return  ResponseEntity.noContent().build();
    }
}
