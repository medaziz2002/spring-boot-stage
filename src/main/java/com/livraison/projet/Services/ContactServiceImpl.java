package com.livraison.projet.Services;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.Contact;
import com.livraison.projet.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact ajouterContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact modifierContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void supprimerContact(Contact contact) {
      contactRepository.delete(contact);
    }

    @Override
    public List<Contact> listeContact() {
        return contactRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
 contactRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public long countById() {
        return contactRepository.countById();
    }
}
