package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CasePowerSupplyLocation;

import java.util.List;
import java.util.Optional;

public interface CasePowerSupplyLocationService {
    CasePowerSupplyLocation create(CasePowerSupplyLocation location);

    Optional<CasePowerSupplyLocation> getOne(long id);

    List<CasePowerSupplyLocation> getAll();

    CasePowerSupplyLocation update(CasePowerSupplyLocation location, long id);

    void delete(long id);
}
