package br.com.marketplace.services;

import br.com.marketplace.models.Avalia;
import br.com.marketplace.repositories.AvaliaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AvaliaService {

    private AvaliaRepository avaliaRepository;

    //Criar Avaliação
    public Avalia criar(Avalia avalia){
        var aux = avaliaRepository.existsById(avalia.getId());
        if (aux){
            throw new RuntimeException();
        }
        return avaliaRepository.save(avalia);
    }

    //Listar todos
    public List<Avalia>listarTodos(){
        var aux = avaliaRepository.findAll();
        if (aux.isEmpty()){
            throw new RuntimeException("Não existe nenhuma avaliação");
        }
        return aux;
    }
    //Buscar por ID
    public Avalia buscarPorId(Long id){
        var aux = avaliaRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("Avaliação não encontrada");
        }
        return aux.get();
    }
    //Atualizar avalição
    public Avalia atualizar(Long id, Avalia novaAvaliacao){
        return avaliaRepository.findById(id).map(avalia -> {
            avalia.setComentario(novaAvaliacao.getComentario());
            avalia.setNota((novaAvaliacao.getNota()));
            avalia.setDataAvaliacao(novaAvaliacao.getDataAvaliacao());
            return avaliaRepository.save(avalia);
        }).orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    //Deletar Avaliação
    public void deletar(Long id){
        var aux = avaliaRepository.existsById((id));
        if(!aux){
            throw new RuntimeException("Não existe avaliação com esse ID"+id);
        }
        avaliaRepository.deleteById(id);
    }
}
