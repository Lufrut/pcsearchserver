package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.Hdd;

import java.util.List;
import java.util.Optional;

public interface HddService {
    Hdd create(Hdd hdd);

    Optional<Hdd> getOne(long id);

    List<Hdd> getAll();

    Hdd update(Hdd hdd, long id);

    void delete(long id);
}
