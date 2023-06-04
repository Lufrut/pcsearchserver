package com.pc.pcsearch.controllers.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerMaterial;
import com.pc.pcsearch.services.cooler.CoolerMaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CoolerMaterialController {
    @Autowired
    CoolerMaterialService coolerMaterialService;

    @PostMapping("/admin/coolerMaterial")
    public CoolerMaterial create(@Valid @RequestBody CoolerMaterial coolerMaterial){
        return coolerMaterialService.create(coolerMaterial);
    }

    @GetMapping("/all/coolerMaterial/{id}")
    public Optional<CoolerMaterial> getOne(@PathVariable long id){
        return coolerMaterialService.getOne(id);
    }

    @GetMapping("/all/coolerMaterial")
    public List<CoolerMaterial> getAll(){
        return coolerMaterialService.getAll();
    }

    @PutMapping("/admin/coolerMaterial/{id}")
    public CoolerMaterial update(
            @Valid @RequestBody CoolerMaterial coolerMaterial,
            @PathVariable long id
    ){
        return coolerMaterialService.update(coolerMaterial, id);
    }
    @DeleteMapping("/admin/coolerMaterial/{id}")
    public String delete(@PathVariable long id){
        coolerMaterialService.delete(id);
        return "Successful deleted";
    }
}
