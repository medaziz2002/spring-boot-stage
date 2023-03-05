package com.livraison.projet.RestController;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Repository.AdminRepository;
import com.livraison.projet.Services.AdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/admin")
public class AdminRestController {

    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedUser = adminRepository.save(admin);
       return savedUser;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> afficherAdmin() {
        return adminService.listeAdmin();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void supprimerAdmin(@PathVariable("id") Long id) {
        adminService.supprimerById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Admin> getAdminById(@PathVariable("id") Long id) {
        return adminService.getAdminById(id);
    }




    @RequestMapping(value="recherche/{email}",method = RequestMethod.GET)
    public  Admin getPrenom(@PathVariable ("email") String email) {

        return adminRepository.findAdminByEmail(email);
    }


    @Autowired
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "registerAdmin")
    public ResponseEntity<?> addadmin(@RequestBody Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedUser = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginStudent(@RequestBody Admin admin)
    {

        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminRepository.findAdminByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else
        {

            Boolean compare = this.bCryptPasswordEncoder.matches(admin.getMdp(), userFromDB.getMdp());

            if (!compare)
            {
                response.put("message", "mot de passe not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            else
            {

                String token = Jwts.builder()
                        .claim("data",userFromDB)

                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();


                response.put("token", token);
                System.out.println("hhh "+token);
                return ResponseEntity.status(HttpStatus.OK).body(response);

            }
        }
    }

    




}