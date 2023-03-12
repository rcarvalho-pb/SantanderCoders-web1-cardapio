package com.ada.web1.cardapio.service;

import com.ada.web1.cardapio.model.Prato;
import com.ada.web1.cardapio.model.enums.Proteina;
import com.ada.web1.cardapio.repository.PratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {
    private final PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }
    public List<Prato> findAll(){
        return pratoRepository.findAll();
    }

    public List<Prato> findByName(String nome){
        return pratoRepository.queryPratoByNomeContainsIgnoreCase(nome);
    }

    public List<Prato> findByProteina(Proteina proteina){
        return pratoRepository.queryPratoByProteinaContains(proteina);
    }

    public Prato findById(Long id){
        return pratoRepository.findById(id).orElse(null);
    }

    public Prato updatePrato(Long id, Prato prato){
        prato.setId(id);
        return pratoRepository.save(prato);
    }

    public void deletePrato(Long id){
        pratoRepository.deleteById(id);
    }

    public Prato save(Prato prato){
        return pratoRepository.save(prato);
    }
}
