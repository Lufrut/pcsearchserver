package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseDesignFeatures;

import java.util.List;
import java.util.Optional;

public interface CaseDesignFeaturesService {
    CaseDesignFeatures create(CaseDesignFeatures designFeatures);

    Optional<CaseDesignFeatures> getOne(long id);

    List<CaseDesignFeatures> getAll();

    CaseDesignFeatures update(CaseDesignFeatures designFeatures, long id);

    void delete(long id);
}
