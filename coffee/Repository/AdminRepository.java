package com.example.coffee.Repository;

import com.example.coffee.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin , Integer > {

    Admin findAdminById(Integer id);
    Admin findAdminByEmail(String email);

    Admin findAdminByPassword(String password);



}
