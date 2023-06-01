package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;
import com.pc.pcsearch.postgresql.repository.powersupply.PowerSupplyProtectionFunctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PowerSupplyProtectionFunctionsServiceImpl implements PowerSupplyProtectionFunctionsService{
    @Autowired
    PowerSupplyProtectionFunctionsRepository powerSupplyProtectionFunctionsRepository;

    @Override
    public PowerSupplyProtectionFunctions create(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions) {
        return powerSupplyProtectionFunctionsRepository.save(powerSupplyProtectionFunctions);
    }

    @Override
    public Optional<PowerSupplyProtectionFunctions> getOne(long id) {
        return powerSupplyProtectionFunctionsRepository.findById(id);
    }

    @Override
    public List<PowerSupplyProtectionFunctions> getAll() {
        return powerSupplyProtectionFunctionsRepository.findAll();
    }

    @Override
    public PowerSupplyProtectionFunctions update(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions, long id) {
        PowerSupplyProtectionFunctions temp = powerSupplyProtectionFunctionsRepository.findById(id).orElse(null);
        if(temp != null)
    {
        temp.setName(powerSupplyProtectionFunctions.getName());
        return powerSupplyProtectionFunctionsRepository.save(temp);
    } else return null;
    }

    @Override
    public void delete(long id) {
        powerSupplyProtectionFunctionsRepository.deleteById(id);
    }
}
