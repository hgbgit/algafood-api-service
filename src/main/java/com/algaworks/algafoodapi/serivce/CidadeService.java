package com.algaworks.algafoodapi.serivce;

import com.algaworks.algafoodapi.data.entity.Cidade;
import com.algaworks.algafoodapi.data.exception.BadRequestException;
import com.algaworks.algafoodapi.data.exception.EntityNotFoundException;
import com.algaworks.algafoodapi.data.repository.CidadeRepository;
import com.algaworks.algafoodapi.data.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    private final EstadoRepository estadoRepository;

    public CidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade findById(Long id) {
        return cidadeRepository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException(String.format("Cidade [id: %d] não existe!", id)));
    }

    @Transactional
    public Cidade create(Cidade cidade) {
        estadoRepository.findById(cidade.getEstado()
                                        .getId())
                        .orElseThrow(() -> new BadRequestException(String.format("Estado [id: %d] não existe!", cidade.getEstado()
                                                                                                                      .getId())));
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public Cidade update(Long id, Cidade cidade) {
        Cidade current = this.findById(id);
        estadoRepository.findById(cidade.getEstado()
                                        .getId())
                        .orElseThrow(() -> new BadRequestException(String.format("Estado [id: %d] não existe!", cidade.getEstado()
                                                                                                                      .getId())));
        BeanUtils.copyProperties(cidade, current, "id");

        return current;
    }

    @Transactional
    public void delete(Long id) {
        Cidade cidade = this.findById(id);
        cidadeRepository.delete(cidade);
    }


}
