package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;

import java.util.List;

public interface PowerSupplyService {
    PowerSupply create(PowerSupply powerSupply);

    PowerSupply getOne(long id);

    List<PowerSupply> getAll();

    PowerSupply update(PowerSupply powerSupply, long id);

    void delete(long id);
}
