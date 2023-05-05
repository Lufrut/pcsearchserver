package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamProducer;

import java.util.List;

public interface RamProducerService {
    RamProducer create(RamProducer ramProducer);

    RamProducer findById(long id);

    List<RamProducer> findAll();

    RamProducer update(RamProducer ramProducer, long id);

    void delete(long id);
}
