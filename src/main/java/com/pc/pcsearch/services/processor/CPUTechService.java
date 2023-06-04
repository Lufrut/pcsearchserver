package com.pc.pcsearch.services.processor;
import com.pc.pcsearch.models.buildpc.processor.CPUTech;

import java.util.List;
import java.util.Optional;
public interface CPUTechService {
    CPUTech create(CPUTech cpuTech);

    Optional<CPUTech> getOne(long id);

    List<CPUTech> getAll();

    CPUTech update(CPUTech cpuTech, long id);

    void delete(long id);
}