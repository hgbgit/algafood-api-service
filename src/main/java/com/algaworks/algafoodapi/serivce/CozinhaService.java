package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.data.entity.Cozinha;
import com.algaworks.algafoodapi.data.exception.EntityNotFoundException;
import com.algaworks.algafoodapi.data.exception.InUseEntityException;
import com.algaworks.algafoodapi.data.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CozinhaService {

    private final CozinhaRepository cozinhaRepository;

    public CozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Cozinha> findAll() {
        return cozinhaRepository.findAll();
    }

    public Cozinha find(Long id) {
        return cozinhaRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException(String.format("Cozinha [id: %d] não existe!", id)));
    }

    @Transactional
    public Cozinha save(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    @Transactional
    public Cozinha update(Long id, Cozinha cozinha) {
        Cozinha current = find(id);
        BeanUtils.copyProperties(cozinha, current, "id");
        return current;
    }

    @Transactional
    public void delete(Long id) {
        Cozinha cozinha = find(id);

        try {
            cozinhaRepository.delete(cozinha);
        } catch (DataIntegrityViolationException ex) {
            throw new InUseEntityException("Cozinha está em uso!");
        }
    }
}
