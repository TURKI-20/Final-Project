package com.example.coffee.Repository;

import com.example.coffee.Model.Drinking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkingRepository extends JpaRepository<Drinking , Integer> {

    Drinking findDrinkingById(Integer id);

    Drinking findDrinkingByPrice(String price);

}
