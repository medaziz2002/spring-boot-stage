package com.livraison.projet.beans;

import com.livraison.projet.Entities.Commande;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommandeDto {

    private Long id;

    private boolean livred;

    private Commande commande;

}
