package com.algaworks.algafoodapi.data.repository;

import com.algaworks.algafoodapi.data.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
