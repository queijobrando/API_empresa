package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.endereco.EnderecoRepository;
import com.empresa.API_empresa.setor.entities.Setor;
import com.empresa.API_empresa.setor.entities.SetorRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final SetorRepository setorRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository,
                              EnderecoRepository enderecoRepository,
                              SetorRepository setorRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRepository = enderecoRepository;
        this.setorRepository = setorRepository;
    }

    @Transactional
    public void cadastrarFuncionario(DadosCadastroFuncionario dados) {
        Setor setor = setorRepository.findById(dados.idSetor())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Funcionario funcionario = new Funcionario(dados, setor);
        funcionarioRepository.save(funcionario);

        Endereco endereco = new Endereco(dados.endereco(), funcionario);
        enderecoRepository.save(endereco);
    }

    public List<Funcionario> listarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario carregarFuncionario(Long id){
        return funcionarioRepository.getReferenceById(id);
    }

}
