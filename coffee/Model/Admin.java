package com.example.coffee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Admin {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @NotEmpty(message = "name can not be empty")
    @Size(min = 4 , message = "name should be 4 or more")
    String name;


    String email;

    @NotEmpty(message = "Password can not be empty")
    String password;
}
