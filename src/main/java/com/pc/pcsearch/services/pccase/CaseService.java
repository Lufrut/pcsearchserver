package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.PCCase;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    PCCase create(PCCase item);

    Optional<PCCase> getOne(long id);

    List<PCCase> getAll();

    PCCase update(PCCase item, long id);

    void delete(long id);
}
