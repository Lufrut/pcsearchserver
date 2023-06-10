package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseSize;

import java.util.List;
import java.util.Optional;

public interface CaseSizeService {
    CaseSize create(CaseSize caseSize);

    Optional<CaseSize> getOne(long id);

    List<CaseSize> getAll();

    CaseSize update(CaseSize caseSize, long id);

    void delete(long id);
}
