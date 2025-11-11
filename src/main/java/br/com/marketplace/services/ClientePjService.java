package br.com.marketplace.services;

import br.com.marketplace.models.ClientePF;
import br.com.marketplace.models.ClientePJ;
import br.com.marketplace.repositories.ClientePfRepository;
import br.com.marketplace.repositories.ClientePjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientePjService {

    private ClientePjRepository clientePjRepository;

    //Criar ClientPJ
    public ClientePJ criar(ClientePJ clientePJ){
        var aux = clientePjRepository.existsById(clientePJ.getCnpj());
        if (aux){
            throw new RuntimeException();
        }
        return clientePjRepository.save(clientePJ);
    }

    //Listar todos
    public List<ClientePJ>listarTodos(){
        var aux = clientePjRepository.findAll();
        if(aux.isEmpty()){
            throw new RuntimeException("Não existe clientes cadastrados.");
        }
        return aux;
    }

    //Buscar por Cnpj
    public ClientePJ buscarPorId(String cnpj){
        var aux = clientePjRepository.findById(cnpj);
        if (aux.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
        return aux.get();
    }

    //Atualizar ClientePJ
    public ClientePJ atualizar(String cnpj, ClientePJ novoClientPj) {
        return clientePjRepository.findById(cnpj).map(clientePJ -> {
            clientePJ.setNome(novoClientPj.getNome());
            return clientePjRepository.save(clientePJ);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //Deletar ClientePJ
    public void deletar(String cnpj){
        var aux = clientePjRepository.existsById((cnpj));
        if (!aux){
            throw new RuntimeException("Não existe o cliente com esse id:" + cnpj );
        }
        clientePjRepository.deleteById(cnpj);
    }
}
