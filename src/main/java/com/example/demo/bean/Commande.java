package com.example.demo.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "commande")
public class Commande {
    private String id;
    private String reference;
    private double total;
    private double totalPaye;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }
}
