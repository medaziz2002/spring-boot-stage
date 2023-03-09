package com.livraison.projet.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AffectationCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private Commande commande;
    @OneToOne
    private Livreur livreur;


    public AffectationCommande(Commande commande, Livreur livreur) {
        this.commande = commande;
        this.livreur = livreur;
    }
}
