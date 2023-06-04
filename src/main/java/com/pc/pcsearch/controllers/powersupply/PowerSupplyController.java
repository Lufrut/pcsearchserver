package com.pc.pcsearch.controllers.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.services.powersupply.PowerSupplyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PowerSupplyController {
    @Autowired
    PowerSupplyService powerSupplyService;

    @PostMapping("/admin/powerSupply")
    public PowerSupply create(@Valid @RequestBody PowerSupply powerSupply){
        return powerSupplyService.create(powerSupply);
    }

    @GetMapping("/all/powerSupply/{id}")
    public Optional<PowerSupply> getPowerSupply(@PathVariable long id){
        return  powerSupplyService.getOne(id);

    }

    @GetMapping("/all/powerSupply")
    public List<PowerSupply> getAllPowerSupply() {
        return powerSupplyService.getAll();
    }

    @PutMapping("/admin/powerSupply/{id}")
    public PowerSupply updatePowerSupply(@Valid @RequestBody PowerSupply powerSupply, @PathVariable long id){
        return powerSupplyService.update(powerSupply, id);
    }

    @DeleteMapping("/admin/powerSupply/{id}")
    public String deletePowerSupply(@PathVariable long id){
        powerSupplyService.delete(id);
        return "Successful deleted";
    }
}
