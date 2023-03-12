package com.ada.web1.cardapio.controller;

import com.ada.web1.cardapio.model.Prato;
import com.ada.web1.cardapio.service.PratoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PratoController {

    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("pratos", pratoService.findAll());
        return "all-prato";
    }
    @GetMapping("/add")
    public String irParaAdicionarPrato(Model model){
        model.addAttribute("prato", new Prato());
        return "add-prato";
    }

    @PostMapping("/addprato")
    public String adicionarPrato(Prato prato){
        pratoService.save(prato);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String irParaEditarPrato(Model model, @PathVariable("id") Long id){
        model.addAttribute("prato", pratoService.findById(id));
        return "edit-prato";
    }

    @PostMapping("updateprato")
    public String editarPrato(Prato prato){
        pratoService.save(prato);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePrato(@PathVariable("id") Long id){
        pratoService.deletePrato(id);
        return "redirect:/";
    }
}
