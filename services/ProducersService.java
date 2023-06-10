package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.Producers;

import java.util.List;
import java.util.Optional;

public interface ProducersService {
    Producers create(Producers producers);

    Optional<Producers> getOne(long id);

    List<Producers> getAll();

    Producers update(Producers producers, long id);

    void delete(long id);
}