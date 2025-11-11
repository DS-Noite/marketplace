package br.com.marketplace.services;

import br.com.marketplace.models.Contrata;
import br.com.marketplace.repositories.ContrataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContrataService {

    private ContrataRepository contrataRepository;

    //Criar contrato
    public Contrata criar(Contrata contrata){
        var aux = contrataRepository.existsById(contrata.getId());
        if (aux){
            throw new RuntimeException();
        }
        return contrataRepository.save(contrata);
    }

    //Listar todos
    public List<Contrata>listarTodos(){
        var aux = contrataRepository.findAll();
        if (aux.isEmpty()){
            throw new RuntimeException("Não existe contratos cadastrados");
        }
        return aux;
    }

    //Buscar por ID
    public Contrata buscarPorId(Long id){
        var aux = contrataRepository.findById(id);
        if (aux.isEmpty()){
            throw  new RuntimeException("Contrato não encontrado");
        }
        return aux.get();
    }

    //Atualizar Contrato
    public Contrata atualizar(Long id, Contrata novoContrato) {
        return contrataRepository.findById(id).map(contrata ->{
            contrata.setValor(novoContrato.getValor());
            contrata.setHorarioAgendamento(novoContrato.getHorarioAgendamento());
            contrata.setFormaPagamento(novoContrato.getFormaPagamento());
            contrata.setServico(novoContrato.getServico());
            return contrataRepository.save(contrata);
        }).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    //Deletar Contrato
    public void deletar(Long id){
        var aux = contrataRepository.existsById((id));
        if (!aux){
            throw new RuntimeException("Não existe contrato com esse ID"+id);
        }
        contrataRepository.deleteById(id);
    }
}
