package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.Hdd;
import com.pc.pcsearch.postgresql.repository.storage.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HddServiceImpl implements HddService {
    @Autowired
    HddRepository hddRepository;

    @Override
    public Hdd create(Hdd hdd) {
        return hddRepository.save(hdd);
    }

    @Override
    public Optional<Hdd> getOne(long id) {
        return hddRepository.findById(id);
    }

    @Override
    public List<Hdd> getAll() {
        return hddRepository.findAll();
    }

    @Override
    public Hdd update(Hdd hdd, long id) {
        Hdd temp = hddRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setProducer(hdd.getProducer());
            temp.setName(hdd.getName());
            temp.setStorageSize(hdd.getStorageSize());
            temp.setSpeed(hdd.getSpeed());
            temp.setFormFactor(hdd.getFormFactor());
            temp.setStorageInterface(hdd.getStorageInterface());
            temp.setBufferSize(hdd.getBufferSize());
            temp.setReadingSpeed(hdd.getReadingSpeed());
            temp.setWritingSpeed(hdd.getWritingSpeed());
            temp.setDescription(hdd.getDescription());
            temp.setRecommendedPrice(hdd.getRecommendedPrice());
            temp.setPerformanceLevel(hdd.getPerformanceLevel());
            return hddRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        hddRepository.deleteById(id);
    }
}
