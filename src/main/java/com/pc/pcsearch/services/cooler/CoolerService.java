package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.Cooler;

import java.util.List;
import java.util.Optional;

public interface CoolerService {
    Cooler create(Cooler cooler);

    Optional<Cooler> getOne(long id);

    List<Cooler> getAll();

    Cooler update(Cooler cooler, long id);

    void delete(long id);
}
