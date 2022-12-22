package com.example.coffee.Service;

import com.example.coffee.Exception.ApiException;
import com.example.coffee.Model.Admin;
import com.example.coffee.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public List<Admin> getAdmin()
    {

        return adminRepository.findAll();
    }

    public void addAdmin(Admin admin)
    {

        adminRepository.save(admin);
    }


    public void deleteAdmin(Integer id) {
        if(adminRepository.findAdminById(id) == null)
            throw new ApiException("Admin not found!");
        adminRepository.deleteById(id);
    }

    public void updateAdmin(Integer id, Admin admin) {
        Admin oldadmin = adminRepository.findAdminById(id);
        if(oldadmin == null)
            throw new ApiException("Admin not found!");

        oldadmin.setName(admin.getName());
        oldadmin.setEmail(admin.getEmail());
        oldadmin.setPassword(admin.getPassword());
        adminRepository.save(oldadmin);

    }

    public Admin check(String password) {
//        Admin admin = adminRepository.findAdminByEmail(password);
        if(adminRepository.findAdminByPassword(password) == null)
            throw new ApiException("password not true!");

        return adminRepository.findAdminByPassword(password);
    }


    public Admin getAdminByEmail(String email)
    {
        if(adminRepository.findAdminByEmail(email) == null)
            throw new ApiException("Admin not found!");
        return adminRepository.findAdminByEmail(email);
    }













}
