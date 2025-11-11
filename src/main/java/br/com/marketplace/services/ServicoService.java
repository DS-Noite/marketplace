package br.com.marketplace.services;

import br.com.marketplace.models.Servico;
import br.com.marketplace.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicoService {

    private ServicoRepository servicoRepository;

    //Criar Servico
    public Servico criar(Servico servico){
        var aux = servicoRepository.existsById(servico.getId());
        if (aux){
            throw new RuntimeException();
        }
        return servicoRepository.save(servico);
    }

    //Listar todos
    public List<Servico>listarTodos(){
        var aux = servicoRepository.findAll();
        if (aux.isEmpty()){
            throw new RuntimeException("Não existe esse serviços cadastrados.");
        }
        return aux;
    }

    //Buscar por ID
    public Servico buscarPorId(Long id){
        var aux = servicoRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("Serviço não encotrado");
        }
        return aux.get();
    }

    //Atualizar Servico
    public Servico atualizar(Long id, Servico novoServico){
        return servicoRepository.findById(id).map(servico -> {
            servico.setDescricaoServico(novoServico.getDescricaoServico());
            servico.setNomeServico(novoServico.getNomeServico());
            return servicoRepository.save(servico);
        }).orElseThrow(()-> new RuntimeException("Serviço não encontrado"));
    }

    //Deletar Servico
    public void deletar(Long id){
                             //Pq tem 2 (())
        var aux = servicoRepository.existsById((id));
        if (!aux){
            throw new RuntimeException("Não existe serviço com esse ID"+id);
        }
        servicoRepository.deleteById(id);
    }
}
