package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;

import java.util.List;

public interface RamMemoryTypeService {

    RamMemoryType create(RamMemoryType ramMemoryType);

    RamMemoryType findById(long id);

    List<RamMemoryType> findAll();

    RamMemoryType update(RamMemoryType ramMemoryType, long id);

    void delete(long id);
}
