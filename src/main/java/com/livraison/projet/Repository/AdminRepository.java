package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdminRepository extends JpaRepository <Admin,Long> {

    Admin findAdminByEmail(String email);
    boolean existsByEmail(String email);






}
