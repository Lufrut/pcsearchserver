package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerMaterial;

import java.util.List;
import java.util.Optional;

public interface CoolerMaterialService {
    CoolerMaterial create(CoolerMaterial coolerMaterial);

    Optional<CoolerMaterial> getOne(long id);

    List<CoolerMaterial> getAll();

    CoolerMaterial update(CoolerMaterial coolerMaterial, long id);

    void delete(long id);
}
