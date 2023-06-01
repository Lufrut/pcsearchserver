package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;

import java.util.List;
import java.util.Optional;

public interface PowerSupplyProtectionFunctionsService {
    PowerSupplyProtectionFunctions create(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions);

    Optional<PowerSupplyProtectionFunctions> getOne(long id);

    List<PowerSupplyProtectionFunctions> getAll();

    PowerSupplyProtectionFunctions update(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions, long id);

    void delete(long id);
}
