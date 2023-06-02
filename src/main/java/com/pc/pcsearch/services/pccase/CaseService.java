package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.Case;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    Case create(Case item);

    Optional<Case> getOne(long id);

    List<Case> getAll();

    Case update(Case item, long id);

    void delete(long id);
}
