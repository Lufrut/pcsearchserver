package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUConnector;

import java.util.List;
import java.util.Optional;

public interface GPUConnectorService {
    GPUConnector create(GPUConnector connector);

    Optional<GPUConnector> getOne(long id);

    List<GPUConnector> getAll();

    GPUConnector update(GPUConnector connector, long id);

    void delete(long id);
}

