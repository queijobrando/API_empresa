package com.empresa.API_empresa.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    void deleteByFuncionarioId(Long id);
}
