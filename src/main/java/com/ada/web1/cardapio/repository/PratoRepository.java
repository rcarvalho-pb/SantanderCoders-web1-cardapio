package com.ada.web1.cardapio.repository;

import com.ada.web1.cardapio.model.Prato;
import com.ada.web1.cardapio.model.enums.Proteina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
    List<Prato> queryPratoByNomeContainsIgnoreCase(String nome);
    List<Prato> queryPratoByProteinaContains(Proteina proteina);
}
