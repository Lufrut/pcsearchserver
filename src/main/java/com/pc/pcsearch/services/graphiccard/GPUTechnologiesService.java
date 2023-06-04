package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUTechnologies;

import java.util.List;
import java.util.Optional;

public interface GPUTechnologiesService {
    GPUTechnologies create(GPUTechnologies technologies);

    Optional<GPUTechnologies> getOne(long id);

    List<GPUTechnologies> getAll();

    GPUTechnologies update(GPUTechnologies technologies, long id);

    void delete(long id);
}

