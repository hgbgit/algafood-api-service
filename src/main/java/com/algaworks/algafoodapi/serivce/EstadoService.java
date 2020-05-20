package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.data.entity.Estado;
import com.algaworks.algafoodapi.data.exception.EntityNotFoundException;
import com.algaworks.algafoodapi.data.exception.InUseEntityException;
import com.algaworks.algafoodapi.data.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException(String.format("Estado [id: %d] não encontrado!", id)));
    }

    @Transactional
    public Estado create(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Transactional
    public Estado update(Long id, Estado estado) {
        Estado current = this.findById(id);

        BeanUtils.copyProperties(estado, current, "id");

        return current;
    }

    @Transactional
    public void delete(Long id) {
        Estado estado = this.findById(id);

        try {
            estadoRepository.delete(estado);
        } catch (DataIntegrityViolationException ex) {
            throw new InUseEntityException(String.format("Estado [id: %d] está em uso! ", id));
        }
    }
}
