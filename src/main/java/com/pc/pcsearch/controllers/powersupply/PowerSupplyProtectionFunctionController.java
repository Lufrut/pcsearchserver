package com.pc.pcsearch.controllers.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;
import com.pc.pcsearch.services.powersupply.PowerSupplyProtectionFunctionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PowerSupplyProtectionFunctionController {
    @Autowired
    PowerSupplyProtectionFunctionsService powerSupplyProtectionFunctionsService;

    @PostMapping("/admin/powerSupplyProtectionFunction")
    public PowerSupplyProtectionFunctions create(@Valid @RequestBody PowerSupplyProtectionFunctions item){
        return powerSupplyProtectionFunctionsService.create(item);
    }

    @GetMapping("/all/powerSupplyProtectionFunction/{id}")
    public Optional<PowerSupplyProtectionFunctions> getPowerSupplyProtectionFunctions(
            @PathVariable long id
    ){
        return powerSupplyProtectionFunctionsService.getOne(id);
    }

    @GetMapping("/all/powerSupplyProtectionFunction")
    public List<PowerSupplyProtectionFunctions> getPowerSupplyProtectionFunctions(){
        return powerSupplyProtectionFunctionsService.getAll();
    }

    @PutMapping("/admin/powerSupplyProtectionFunction/{id}")
    public PowerSupplyProtectionFunctions update(
            @Valid @RequestBody PowerSupplyProtectionFunctions powerSupplyProtectionFunctions,
            @PathVariable long id
    ){
        return powerSupplyProtectionFunctionsService.update(powerSupplyProtectionFunctions, id);
    }

    @DeleteMapping("/admin/powerSupplyProtectionFunctions/{id}")
    public String delete(@PathVariable long id){
        powerSupplyProtectionFunctionsService.delete(id);
        return "Successful deleted";
    }
}
