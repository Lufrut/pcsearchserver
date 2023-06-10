package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUMemoryType;

import java.util.List;
import java.util.Optional;

public interface GPUMemoryTypeService {
    GPUMemoryType create(GPUMemoryType memoryType);

    Optional<GPUMemoryType> getOne(long id);

    List<GPUMemoryType> getAll();

    GPUMemoryType update(GPUMemoryType memoryType, long id);

    void delete(long id);
}
