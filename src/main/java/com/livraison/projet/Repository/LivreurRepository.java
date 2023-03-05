package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {

        Livreur findLivreurByEmail(String email);
    boolean existsByEmail(String email);
}
