package com.livraison.projet.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livraison  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean livred;

  @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CommandeId", referencedColumnName = "id")
    private  Commande commande;

    public Livraison(boolean livred,Commande commande) {
        this.livred = livred;
        this.commande = commande;
    }






}
