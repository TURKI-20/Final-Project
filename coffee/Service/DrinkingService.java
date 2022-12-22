package com.example.coffee.Service;

import com.example.coffee.Exception.ApiException;
import com.example.coffee.Model.Admin;
import com.example.coffee.Model.Drinking;
import com.example.coffee.Repository.DrinkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkingService {
    private final DrinkingRepository drinkingRepository;


    public List<Drinking> getDrinking()
    {

        return drinkingRepository.findAll();
    }

    public void addDrinking(Drinking drinking)
    {

        drinkingRepository.save(drinking);
    }

    public void deleteDrinking(Integer id) {
        if(drinkingRepository.findDrinkingById(id) == null)
            throw new ApiException("this Drinking not found!");
        drinkingRepository.deleteById(id);
    }

    public void updateDrinking(Integer id, Drinking drinking) {
        Drinking olddrinking = drinkingRepository.findDrinkingById(id);
        if(olddrinking == null)
            throw new ApiException(" this Drinking not found!");

        olddrinking.setName(drinking.getName());
        olddrinking.setPrice(drinking.getPrice());
        drinkingRepository.save(olddrinking);

    }


    public Drinking getDrinkingByPrice(String price)
    {
        if(drinkingRepository.findDrinkingByPrice(price) == null)
            throw new ApiException("this drinking not found!");
        return drinkingRepository.findDrinkingByPrice(price);
    }
}
