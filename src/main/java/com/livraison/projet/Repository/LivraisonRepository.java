package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivraisonRepository extends JpaRepository<Livraison,Long> {





}
