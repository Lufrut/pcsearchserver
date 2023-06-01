package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.Ram;

import java.util.List;
import java.util.Optional;

public interface RamService {
    Ram create(Ram ram);

    Optional<Ram> findById(long id);

    List<Ram> findAll();

    Ram update(Ram ram, long id);

    void delete(long id);
}
