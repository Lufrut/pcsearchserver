package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;

import java.util.List;

public interface PowerSupplyProtectionFunctionsService {
    PowerSupplyProtectionFunctions create(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions);

    PowerSupplyProtectionFunctions getOne(long id);

    List<PowerSupplyProtectionFunctions> getAll();

    PowerSupplyProtectionFunctions update(PowerSupplyProtectionFunctions powerSupplyProtectionFunctions, long id);

    void delete(long id);
}
