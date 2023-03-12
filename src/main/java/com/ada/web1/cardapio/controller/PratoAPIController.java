package com.ada.web1.cardapio.controller;

import com.ada.web1.cardapio.model.Prato;
import com.ada.web1.cardapio.model.enums.Proteina;
import com.ada.web1.cardapio.service.PratoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PratoAPIController {

    private final PratoService pratoService;

    public PratoAPIController(PratoService pratoService) {
        this.pratoService = pratoService;
    }
    @PostMapping("/save")
    public Prato addPrato(@RequestBody Prato prato){
        return pratoService.save(prato);
    }

    @GetMapping("/")
    public List<Prato> findAll(){
        return pratoService.findAll();
    }

    @GetMapping("/search/nome")
    public List<Prato> findByName(@RequestParam("nome") String nome){
        return pratoService.findByName(nome);
    }

    @GetMapping("/search/proteina")
    public List<Prato> findByProteina(@RequestParam("proteina") Proteina proteina){
        return pratoService.findByProteina(proteina);
    }

    @PostMapping("/update")
    public Prato updatePrato(@RequestParam("id") Long id, @RequestBody Prato prato){
        prato.setId(id);
        return pratoService.save(prato);
    }

    @DeleteMapping("/{id}")
    public void deletePrato(@PathVariable("id") Long id){
        pratoService.deletePrato(id);
    }

}
