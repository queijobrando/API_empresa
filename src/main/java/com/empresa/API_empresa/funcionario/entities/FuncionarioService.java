package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.endereco.EnderecoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    private EnderecoRepository enderecoRepository;

    @Transactional
    public void cadastrarFuncionario(DadosCadastroFuncionario dados) {
        Funcionario funcionario = new Funcionario(dados);
        funcionarioRepository.save(funcionario);

        Endereco endereco = new Endereco(dados.endereco(), funcionario);
        enderecoRepository.save(endereco);
    }
}
