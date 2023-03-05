package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact,Long> {


    @Query("select count(*) from  Contact")
    long countById();
}
