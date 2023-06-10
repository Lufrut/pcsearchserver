package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;

import java.util.List;
import java.util.Optional;

public interface RamMemoryTypeService {

    RamMemoryType create(RamMemoryType ramMemoryType);

    Optional<RamMemoryType> findById(long id);

    List<RamMemoryType> findAll();

    RamMemoryType update(RamMemoryType ramMemoryType, long id);

    void delete(long id);
}
