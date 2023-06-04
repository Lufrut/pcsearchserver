package com.pc.pcsearch.services.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUPcieVersion;

import java.util.List;
import java.util.Optional;
public interface CPUPcieVersionService {
    CPUPcieVersion create(CPUPcieVersion cpuPcieVersion);

    Optional<CPUPcieVersion> getOne(long id);

    List<CPUPcieVersion> getAll();

    CPUPcieVersion update(CPUPcieVersion cpuPcieVersion, long id);

    void delete(long id);
}
