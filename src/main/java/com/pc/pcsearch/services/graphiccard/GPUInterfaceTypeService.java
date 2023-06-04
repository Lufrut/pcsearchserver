package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUInterfaceType;

import java.util.List;
import java.util.Optional;

public interface GPUInterfaceTypeService {
    GPUInterfaceType create(GPUInterfaceType interfaceType);

    Optional<GPUInterfaceType> getOne(long id);

    List<GPUInterfaceType> getAll();

    GPUInterfaceType update(GPUInterfaceType interfaceType, long id);

    void delete(long id);
}

