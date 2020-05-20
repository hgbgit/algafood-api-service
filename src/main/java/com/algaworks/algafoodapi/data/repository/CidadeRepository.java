package com.algaworks.algafoodapi.data.repository;

import com.algaworks.algafoodapi.data.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
