package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.funcionario.dtos.AtualizarDadosFuncionario;
import com.empresa.API_empresa.funcionario.dtos.DadosCadastroFuncionario;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import com.empresa.API_empresa.setor.entities.Setor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;


    public Funcionario(DadosCadastroFuncionario dados, Setor setor) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cargo = dados.cargo();
        this.setor = setor;
    }

    public void atualizarInformacoes(AtualizarDadosFuncionario dados) {
        if (dados.email() != null){
            this.email = dados.email();
        }
    }
    /*
    private Setor setor;
     */
}
