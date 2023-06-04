package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardChipset;

import java.util.List;
import java.util.Optional;

public interface MotherboardChipsetService {
    MotherboardChipset create(MotherboardChipset chipset);

    Optional<MotherboardChipset> getOne(long id);

    List<MotherboardChipset> getAll();

    MotherboardChipset update(MotherboardChipset chipset, long id);

    void delete(long id);
}
