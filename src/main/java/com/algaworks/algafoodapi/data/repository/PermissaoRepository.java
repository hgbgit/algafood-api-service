package com.algaworks.algafoodapi.data.repository;

import com.algaworks.algafoodapi.data.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, String> {
}
