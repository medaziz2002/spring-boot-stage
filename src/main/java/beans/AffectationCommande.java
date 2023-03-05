package beans;

import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livreur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AffectationCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      @OneToOne
    private Commande commande;
      @OneToOne
      private Livreur livreur;



      public AffectationCommande(Commande commande,Livreur livreur)
      {
          this.commande=commande;
          this.livreur=livreur;
      }





}
