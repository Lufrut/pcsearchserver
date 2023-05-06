package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProducer;
import com.pc.pcsearch.postgresql.repository.powersupply.PowerSupplyProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyProducerServiceImpl implements PowerSupplyProducerService{
    @Autowired
    PowerSupplyProducerRepository powerSupplyProducerRepository;

    @Override
    public PowerSupplyProducer create(PowerSupplyProducer powerSupplyProducer) {
        return powerSupplyProducerRepository.save(powerSupplyProducer);
    }

    @Override
    public PowerSupplyProducer getOne(long id) {
        return powerSupplyProducerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<PowerSupplyProducer> getAll() {
        return powerSupplyProducerRepository.findAll();
    }

    @Override
    public PowerSupplyProducer update(PowerSupplyProducer powerSupplyProducer, long id) {
        PowerSupplyProducer temp = powerSupplyProducerRepository.findById(id).orElseThrow();
        temp.setProducer(powerSupplyProducer.getProducer());
        return powerSupplyProducerRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        powerSupplyProducerRepository.deleteById(id);
    }
}
