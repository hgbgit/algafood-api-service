package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.data.entity.Restaurante;
import com.algaworks.algafoodapi.data.exception.BadRequestException;
import com.algaworks.algafoodapi.data.exception.EntityNotFoundException;
import com.algaworks.algafoodapi.data.exception.InUseEntityException;
import com.algaworks.algafoodapi.data.repository.CozinhaRepository;
import com.algaworks.algafoodapi.data.repository.RestauranteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    private final CozinhaRepository cozinhaRepository;

    public RestauranteService(RestauranteRepository restauranteRepository, CozinhaRepository cozinhaRepository) {
        this.restauranteRepository = restauranteRepository;
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    public Restaurante find(Long id) {
        return restauranteRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException(String.format("Restaurante [id: %d] não existe!", id)));
    }

    @Transactional
    public Restaurante save(Restaurante restaurante) {
        cozinhaRepository.findById(restaurante.getCozinha()
                                              .getId())
                         .orElseThrow(() -> new BadRequestException(String.format("Cozinha [id: %d] não existe!", restaurante.getCozinha()
                                                                                                                             .getId())));

        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public Restaurante update(Long id, Restaurante restaurante) {
        Restaurante current = find(id);
        cozinhaRepository.findById(restaurante.getCozinha()
                                              .getId())
                         .orElseThrow(() -> new BadRequestException(String.format("Cozinha [id: %d] não existe!", restaurante.getCozinha()
                                                                                                                             .getId())));

        BeanUtils.copyProperties(restaurante, current, "id");
        return current;
    }

    @Transactional
    public void delete(Long id) {
        Restaurante restaurante = find(id);

        try {
            restauranteRepository.delete(restaurante);
        } catch (DataIntegrityViolationException ex) {
            throw new InUseEntityException("Restaurante está em uso!");
        }
    }
}
