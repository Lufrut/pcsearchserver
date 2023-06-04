package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;

import java.util.List;
import java.util.Optional;

public interface MotherboardService {
    Motherboard create(Motherboard motherboard);

    Optional<Motherboard> getOne(long id);

    List<Motherboard> getAll();

    Motherboard update(Motherboard motherboard, long id);

    void delete(long id);
}
