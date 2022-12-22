package com.example.coffee.Controller;

import com.example.coffee.Dto.ApiResponse;
import com.example.coffee.Model.Desert;
import com.example.coffee.Service.DesertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coffee/desert")
@RequiredArgsConstructor
public class DesertController {

    private final DesertService desertService;

    @GetMapping("/get")
    public ResponseEntity getDesert() {

        return ResponseEntity.status(201).body(desertService.getDesert());
    }

    @PostMapping("/add")
    public ResponseEntity addDesert(@RequestBody @Valid Desert desert) {
        desertService.addDesert(desert);
        return ResponseEntity.status(201).body(new ApiResponse("Desert Added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDesert(@PathVariable Integer id, @RequestBody @Valid Desert desert) {
        desertService.updateDesert(id, desert);
        return ResponseEntity.status(201).body(new ApiResponse("Desert Updated!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDesert(@PathVariable Integer id) {
        desertService.deleteDesert(id);
        return ResponseEntity.status(201).body(new ApiResponse("Desert deleted!"));
    }

    @GetMapping("/get/by/{price}")
    public ResponseEntity getDesertByPrice(@PathVariable String price) {
        return ResponseEntity.status(201).body(desertService.getDesertByPrice(price));
    }
}