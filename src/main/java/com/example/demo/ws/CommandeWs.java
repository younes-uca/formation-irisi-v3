package com.example.demo.ws;

import com.example.demo.bean.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/command/")
public class CommandeWs {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }

    @PostMapping("")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @DeleteMapping("reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @GetMapping("")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
}
