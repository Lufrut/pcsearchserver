package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProducer;

import java.util.List;

public interface PowerSupplyProducerService {
    PowerSupplyProducer create(PowerSupplyProducer powerSupplyProducer);

    PowerSupplyProducer getOne(long id);

    List<PowerSupplyProducer> getAll();

    PowerSupplyProducer update(PowerSupplyProducer powerSupplyProducer, long id);

    void delete(long id);
}
