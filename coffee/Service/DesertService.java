package com.example.coffee.Service;

import com.example.coffee.Exception.ApiException;
import com.example.coffee.Model.Admin;
import com.example.coffee.Model.Desert;
import com.example.coffee.Model.Drinking;
import com.example.coffee.Repository.DesertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesertService {
    private final DesertRepository desertRepository;

    public List<Desert> getDesert()
    {

        return desertRepository.findAll();
    }

    public void addDesert(Desert desert)
    {

        desertRepository.save(desert);
    }

    public void deleteDesert(Integer id) {
        if(desertRepository.findDesertById(id) == null)
            throw new ApiException("Desert not found!");
        desertRepository.deleteById(id);
    }

    public void updateDesert(Integer id, Desert desert) {
        Desert olddesert = desertRepository.findDesertById(id);
        if(olddesert == null)
            throw new ApiException(" this Desert not found!");
        olddesert.setName(desert.getName());
        olddesert.setPrice(desert.getPrice());
        desertRepository.save(olddesert);
    }

    public Desert getDesertByPrice(String price)
    {
        if(desertRepository.findDesertByPrice(price) == null)
            throw new ApiException("this desert not found!");
        return desertRepository.findDesertByPrice(price);
    }
}
