package br.com.marketplace.controllers;


import br.com.marketplace.models.Cliente;
import br.com.marketplace.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    //Criar
    @PostMapping
    public ResponseEntity criar(@RequestBody Cliente cliente, UriComponentsBuilder builder){
        Cliente aux = this.clienteService.criar(cliente);
        var uri = builder.path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        var aux = clienteService.buscarPorId(id);
        return ResponseEntity.ok(aux);
    }

    //Atualizar
    //@PutMapping("/{id}")
    //public ResponseEntity atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
      //var aux = clienteService.(id, cliente);
        //return ResponseEntity.ok(aux);
    //}

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return  ResponseEntity.noContent().build();
    }
}
