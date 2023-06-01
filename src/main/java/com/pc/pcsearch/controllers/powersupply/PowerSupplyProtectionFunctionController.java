package com.pc.pcsearch.controllers.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;
import com.pc.pcsearch.services.powersupply.PowerSupplyProtectionFunctionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PowerSupplyProtectionFunctionController {
    @Autowired
    PowerSupplyProtectionFunctionsService powerSupplyProtectionFunctionsService;

    @PostMapping("/admin/powerSupplyProtectionFunction")
    public PowerSupplyProtectionFunctions create(@Valid @RequestBody PowerSupplyProtectionFunctions item){
        return powerSupplyProtectionFunctionsService.create(item);
    }

    @GetMapping("/user/powerSupplyProtectionFunction/{id}")
    public PowerSupplyProtectionFunctions getPowerSupplyProtectionFunctions(
            @PathVariable long id
    ){
        return powerSupplyProtectionFunctionsService.getOne(id);
    }

    @GetMapping("/user/powerSupplyProtectionFunction")
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
