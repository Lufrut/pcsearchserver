package com.pc.pcsearch.services.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUGeneration;

import java.util.List;
import java.util.Optional;
public interface CPUGenerationService {
    CPUGeneration create(CPUGeneration cpuGeneration);

    Optional<CPUGeneration> getOne(long id);

    List<CPUGeneration> getAll();

    CPUGeneration update(CPUGeneration cpuGeneration, long id);

    void delete(long id);
}
