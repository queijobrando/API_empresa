package com.empresa.API_empresa.setor.entities;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Transactional
    public void cadastrarSetor(DadosCadastroSetor dados){
        Setor setor = new Setor(dados);
        setorRepository.save(setor);
    }
}
