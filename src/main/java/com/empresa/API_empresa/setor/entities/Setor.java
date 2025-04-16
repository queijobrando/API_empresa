package com.empresa.API_empresa.setor.entities;

import com.empresa.API_empresa.setor.enums.Area;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Setor")
@Table(name = "setor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Area area;

    public Setor(DadosCadastroSetor dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.area = dados.area();
    }
}
