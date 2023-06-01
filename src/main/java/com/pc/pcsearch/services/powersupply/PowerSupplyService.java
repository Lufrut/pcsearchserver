package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;

import java.util.List;
import java.util.Optional;

public interface PowerSupplyService {
    PowerSupply create(PowerSupply powerSupply);

    Optional<PowerSupply> getOne(long id);

    List<PowerSupply> getAll();

    PowerSupply update(PowerSupply powerSupply, long id);

    void delete(long id);
}
