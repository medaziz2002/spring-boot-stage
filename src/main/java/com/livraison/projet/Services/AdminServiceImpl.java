package com.livraison.projet.Services;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin ajouterAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin modifierAdmin(Admin admin) {
        return adminRepository.save(admin);
    }


    @Override
    public void supprimerAdmin(Admin admin) {
     adminRepository.delete(admin);
    }

    @Override
    public List<Admin> listeAdmin() {
        return adminRepository.findAll();
    }


    @Override
    public void supprimerById(Long id) {
      adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }



    
}
