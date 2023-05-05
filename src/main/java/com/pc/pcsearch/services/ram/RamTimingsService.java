package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamTimings;

import java.util.List;

public interface RamTimingsService {
    RamTimings create(RamTimings ramTimings);

    RamTimings findById(long id);

    List<RamTimings> findAll();

    RamTimings update(RamTimings ramTimings, long id);

    void delete(long id);
}
