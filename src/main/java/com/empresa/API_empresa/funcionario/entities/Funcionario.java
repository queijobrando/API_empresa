package com.empresa.API_empresa.funcionario.entities;

import com.empresa.API_empresa.endereco.Endereco;
import com.empresa.API_empresa.funcionario.enums.Cargo;
import com.empresa.API_empresa.setor.entities.Setor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Funcionario")
@Table(name = "medicos")
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

    @Embedded
    private Endereco endereco;

    public Funcionario(DadosCadastroFuncionario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cargo = dados.cargo();
        this.endereco = new Endereco(dados.endereco());
    }
    /*
    private Setor setor;
     */
}
