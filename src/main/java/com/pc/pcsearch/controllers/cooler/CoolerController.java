package com.pc.pcsearch.controllers.cooler;

import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.services.cooler.CoolerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CoolerController {
    @Autowired
    CoolerService coolerService;

    @PostMapping("/admin/cooler")
    public Cooler create(Cooler cooler){
        return coolerService.create(cooler);
    }

    @GetMapping("/all/cooler/{id}")
    public Optional<Cooler> getOne(@PathVariable long id){
        return coolerService.getOne(id);
    }

    @GetMapping("/all/cooler")
    public List<Cooler> getAll(){
        return coolerService.getAll();
    }

    @PutMapping("/admin/cooler/{id}")
    public Cooler update(@Valid @RequestBody Cooler cooler, @PathVariable long id){
        return coolerService.update(cooler, id);
    }

    @DeleteMapping ("/admin/cooler/{id}")
    public String delete(@PathVariable long id){
        coolerService.delete(id);
        return "Successful deleted";
    }
}
