package com.example.demo.service;

import com.example.demo.bean.Commande;
import com.example.demo.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    public int save(Commande commande) {
        if (findByReference(commande.getReference()) == null) {
            commandeDao.save(commande);
            return 1;
        } else {
            return -1;
        }
    }

    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
}
