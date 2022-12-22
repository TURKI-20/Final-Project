package com.example.coffee.Repository;

import com.example.coffee.Model.Desert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesertRepository extends JpaRepository<Desert ,Integer> {

    Desert findDesertById(Integer id);

    Desert findDesertByPrice(String price);
}
