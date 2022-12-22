package com.example.coffee.Controller;

import com.example.coffee.Dto.ApiResponse;
import com.example.coffee.Model.Admin;
import com.example.coffee.Model.Drinking;
import com.example.coffee.Service.DrinkingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coffee/drinking")
@RequiredArgsConstructor
public class DrinkingController {

    private final DrinkingService drinkingService;


    @GetMapping("/get")
    public ResponseEntity getDrinking() {

        return ResponseEntity.status(201).body(drinkingService.getDrinking());
    }

    @PostMapping("/add")
    public ResponseEntity addDrinking(@RequestBody @Valid Drinking drinking) {
        drinkingService.addDrinking(drinking);
        return ResponseEntity.status(201).body(new ApiResponse("Drinking Added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDrinking(@PathVariable Integer id, @RequestBody @Valid Drinking drinking) {
        drinkingService.updateDrinking(id, drinking);
        return ResponseEntity.status(201).body(new ApiResponse("Drinking Updated!"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDrinking(@PathVariable Integer id) {
        drinkingService.deleteDrinking(id);
        return ResponseEntity.status(201).body(new ApiResponse("Drinking deleted!"));
    }

    @GetMapping("/get/by/price/{price}")
    public ResponseEntity getDrinkingByPrice( @PathVariable String price) {
        return ResponseEntity.status(201).body(drinkingService.getDrinkingByPrice(price));
    }

}
