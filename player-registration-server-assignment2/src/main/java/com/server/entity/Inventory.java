package com.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
public class Inventory implements Comparable <Inventory>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId")
    private Long id;
    private String name;
    private String sport;
    private int quantity;
    private double pricePerUnit;
    private Date added;
    private Date updated;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.EAGER)

    @PrePersist
    void createdAt() {
        this.added= new Date();
        this.updated = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.added = new Date();
        this.updated = new Date();
    }

    public Inventory(String name, String sport, int quantity, double price) {
        this.name = name;
        this.sport = sport;
        this.quantity = quantity;
        this.pricePerUnit = price;
    }

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public int compareTo(Inventory o) {
        return added.compareTo(o.added);
    }
}

