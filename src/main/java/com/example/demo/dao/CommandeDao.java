package com.example.demo.dao;

import com.example.demo.bean.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends MongoRepository<Commande,String> {
    Commande findByReference(String reference);
    int deleteByReference(String reference);
}
