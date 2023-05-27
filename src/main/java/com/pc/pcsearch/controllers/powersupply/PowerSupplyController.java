package com.pc.pcsearch.controllers.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.services.powersupply.PowerSupplyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerSupplyController {
    @Autowired
    PowerSupplyService powerSupplyService;

    @PostMapping("/powerSupply")
    public PowerSupply create(@Valid @RequestBody PowerSupply powerSupply){
        return powerSupplyService.create(powerSupply);
    }
}
