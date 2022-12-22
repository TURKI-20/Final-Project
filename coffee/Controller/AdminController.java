package com.example.coffee.Controller;

import com.example.coffee.Dto.ApiResponse;
import com.example.coffee.Model.Admin;
import com.example.coffee.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coffee/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/get")
    public ResponseEntity getAdmin() {

        return ResponseEntity.status(201).body(adminService.getAdmin());
    }


    @PostMapping("/add")
    public ResponseEntity addAdmin(@RequestBody @Valid Admin admin) {
        adminService.addAdmin(admin);
        return ResponseEntity.status(201).body(new ApiResponse("Admin Added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmin(@PathVariable Integer id, @RequestBody @Valid Admin admin) {
        adminService.updateAdmin(id, admin);
        return ResponseEntity.status(201).body(new ApiResponse("Admin Updated!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.status(201).body(new ApiResponse("Admin deleted!"));
    }


    @GetMapping("/check/{password}")
    public ResponseEntity check(@PathVariable String password) {
        return ResponseEntity.status(201).body(adminService.check(password));
    }

    @GetMapping("/get/by/{email}")
    public ResponseEntity getAdminByEmail(@PathVariable String email) {
        return ResponseEntity.status(201).body(adminService.getAdminByEmail(email));
    }
}