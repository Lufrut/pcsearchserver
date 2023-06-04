package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.FormFactor;

import java.util.List;
import java.util.Optional;

public interface FormFactorService {
    FormFactor create(FormFactor formFactor);

    Optional<FormFactor> getOne(long id);

    List<FormFactor> getAll();

    FormFactor update(FormFactor formFactor, long id);

    void delete(long id);
}