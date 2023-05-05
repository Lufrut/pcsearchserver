package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamProducer;
import com.pc.pcsearch.postgresql.repository.ram.RamProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamProducerServiceImpl implements RamProducerService{
    @Autowired
    RamProducerRepository ramProducerRepository;
    @Override
    public RamProducer create(RamProducer ramProducer) {
        return ramProducerRepository.save(ramProducer);
    }

    @Override
    public RamProducer findById(long id) {
        return ramProducerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<RamProducer> findAll() {
        return ramProducerRepository.findAll();
    }

    @Override
    public RamProducer update(RamProducer ramProducer, long id) {
        RamProducer temp = ramProducerRepository.findById(id).orElseThrow();
        temp.setProducer(ramProducer.getProducer());
        return ramProducerRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        ramProducerRepository.deleteById(id);
    }
}
