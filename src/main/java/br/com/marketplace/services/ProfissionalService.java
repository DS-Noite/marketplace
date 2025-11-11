package br.com.marketplace.services;

import br.com.marketplace.models.Pessoa;
import br.com.marketplace.models.Profissional;
import br.com.marketplace.repositories.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private ProfissionalRepository profissionalRepository;

    //Criar profissional
    public Profissional criar(Profissional profissional){

        var aux = profissionalRepository.existsById(profissional.getCnpj());
        if (aux){
            throw new RuntimeException();
        }
        return profissionalRepository.save(profissional);
    }

    //Listar todos
    public List<Profissional> listarTodos(){
        return profissionalRepository.findAll();
    }

    //Buscar pelo cnpj
    public Profissional buscarPorId(String cnpj){
        var aux = profissionalRepository.findById(cnpj);
        if (aux.isEmpty()){
            throw new RuntimeException("Profissional não existe");
        }
        return aux.get();
    }

    //Atualizar profissional
    public Profissional atualizar(String cnpj, Profissional novoProfissional){
        return profissionalRepository.findById(cnpj).map(profissional -> {
            profissional.setNome(novoProfissional.getNome());
            return profissionalRepository.save(profissional);
        }).orElseThrow(() -> new RuntimeException("Profissional não encontrada"));
    }

    //Deletar profissional
    public void deletar(String cnpj) {

        profissionalRepository.deleteById(cnpj);
    }
}
