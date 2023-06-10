package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.Ssd;

import java.util.List;
import java.util.Optional;

public interface SsdService {
    Ssd create(Ssd ssd);

    Optional<Ssd> getOne(long id);

    List<Ssd> getAll();

    Ssd update(Ssd ssd, long id);

    void delete(long id);
}
