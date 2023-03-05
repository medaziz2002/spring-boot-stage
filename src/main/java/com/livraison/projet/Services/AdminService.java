package com.livraison.projet.Services;

import com.livraison.projet.Entities.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Admin ajouterAdmin(Admin admin);
    Admin modifierAdmin(Admin admin);
    void supprimerAdmin(Admin admin);
    List<Admin> listeAdmin();
    void supprimerById(Long id);
    Optional<Admin> getAdminById(Long id);







}
