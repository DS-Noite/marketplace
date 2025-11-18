package br.com.marketplace.services;


import br.com.marketplace.models.Cliente;
import br.com.marketplace.models.Contrata;
import br.com.marketplace.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    //Criar contrato
    public Cliente criar(Cliente cliente){
        var aux = clienteRepository.existsById(cliente.getId());
        if (aux){
            throw new RuntimeException();
        }
        return clienteRepository.save(cliente);
    }

    //Listar todos
    public List<Cliente> listarTodos(){
        var aux = clienteRepository.findAll();
        if (aux.isEmpty()){
            throw new RuntimeException("Não existe clientes cadastrados");
        }
        return aux;
    }

    //Buscar por ID

    public Cliente buscarPorId(Long id){
        var aux = clienteRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
        return aux.get();
    }

    //Atualizar Cliente


    //Deletar Cliente
    public void deletar(Long id){
        var aux = clienteRepository.existsById((id));
        if (!aux) {
            throw new RuntimeException("Não existe cliente com esse ID" + id);
            }
        clienteRepository.deleteById(id);
        }
}


