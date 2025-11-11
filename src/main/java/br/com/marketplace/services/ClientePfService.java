package br.com.marketplace.services;

import br.com.marketplace.models.ClientePF;
import br.com.marketplace.repositories.ClientePfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientePfService {

    private ClientePfRepository clientePfRepository;

    //Criar ClientPF
    public ClientePF criar(ClientePF clientePF){
        var aux = clientePfRepository.existsById(clientePF.getCpf());
        if (aux){
            throw new RuntimeException();
        }
        return clientePfRepository.save(clientePF);
    }

    //Listar todos
    public List<ClientePF>listartodos(){
        var aux = clientePfRepository.findAll();
        if(aux.isEmpty()){
            throw new RuntimeException("Não existe clientes cadastrados.");
        }
        return aux;
    }

    //Buscar por Cpf
    public ClientePF buscarPorId(String cpf){
        var aux = clientePfRepository.findById(cpf);
        if (aux.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
        return aux.get();
    }

    //Atualizar ClientePF
    public ClientePF atualizar(String cpf, ClientePF novoclientPf) {
        return clientePfRepository.findById(cpf).map(clientePF -> {
            clientePF.setNome(novoclientPf.getNome());
            return clientePfRepository.save(clientePF);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //Deletar CLiente
    public void deletar(String cpf){
        var aux = clientePfRepository.existsById(cpf);
        if (!aux){
            throw new RuntimeException("Não existe o cliente com esse id:" + cpf );
        }
        clientePfRepository.deleteById(cpf);
    }
}
