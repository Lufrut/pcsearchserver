package com.pc.pcsearch.services.processor;

import com.pc.pcsearch.models.buildpc.processor.Processor;

import java.util.List;
import java.util.Optional;

public interface ProcessorService {
    Processor create(Processor processor);

    Optional<Processor> getOne(long id);

    List<Processor> getAll();

    Processor update(Processor processor, long id);

    void delete(long id);
}
