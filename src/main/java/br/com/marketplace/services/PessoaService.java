package br.com.marketplace.services;

import br.com.marketplace.models.Pessoa;
import br.com.marketplace.models.Profissional;
import br.com.marketplace.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service // Diz ao Spring que essa classe é um componente de serviço
public class PessoaService {

    private PessoaRepository pessoaRepository;

    //Criar pessoa
    public Pessoa criar(Pessoa pessoa){
        var aux = pessoaRepository.existsById(pessoa.getId());
        if(aux){
            throw new RuntimeException();
        }
        return pessoaRepository.save(pessoa);
    }

    //Listar todos
    public List<Pessoa>listarTodos(){
        return pessoaRepository.findAll();
    }

    //Buscar por ID
    public Pessoa buscarPorId(Long id){
        var aux = pessoaRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("pesosa não achada");
        }
        return aux.get();
    }

    //Atualizar pessoa
    public Pessoa atualizar(Long id, Pessoa novaPessoa){
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(novaPessoa.getNome());
            return pessoaRepository.save(pessoa);
                }).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    //Deletar pessoa
    public void deletar(Long id){
        pessoaRepository.deleteById(id);
    }
}
