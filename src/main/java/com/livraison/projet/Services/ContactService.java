package com.livraison.projet.Services;


import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.Contact;

import java.util.List;
import java.util.Optional;


public interface ContactService {


    Contact ajouterContact(Contact contact);
    Contact modifierContact(Contact contact);
    void supprimerContact(Contact contact);
    List<Contact> listeContact();
    void supprimerById(Long id);
    Optional<Contact> getContactById(Long id);

    long countById();
}

