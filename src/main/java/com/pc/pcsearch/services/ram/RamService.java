package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.Ram;

import java.util.List;

public interface RamService {
    Ram create(Ram ram);

    Ram findById(long id);

    List<Ram> findAll();

    Ram update(Ram ram, long id);

    void delete(long id);
}
