package com.livraison.projet.beans;

import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livraison;
import jakarta.persistence.Lob;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LivraisonDto {



    private Long id;


    private boolean livred;





    private Commande commande;




}
