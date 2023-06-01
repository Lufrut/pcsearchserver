package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamTimings;

import java.util.List;
import java.util.Optional;

public interface RamTimingsService {
    RamTimings create(RamTimings ramTimings);

    Optional<RamTimings> findById(long id);

    List<RamTimings> findAll();

    RamTimings update(RamTimings ramTimings, long id);

    void delete(long id);
}
