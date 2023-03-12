package com.ada.web1.cardapio.model;

import com.ada.web1.cardapio.model.enums.Acompanhamento;
import com.ada.web1.cardapio.model.enums.Proteina;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Prato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Proteina proteina;
    private List<Acompanhamento> acompanhamentos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Proteina getProteina() {
        return proteina;
    }

    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }

    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
