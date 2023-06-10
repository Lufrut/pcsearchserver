package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.Ssd;
import com.pc.pcsearch.postgresql.repository.storage.SsdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SsdServiceImpl implements SsdService{
    @Autowired
    SsdRepository ssdRepository;

    @Override
    public Ssd create(Ssd ssd) {
        return ssdRepository.save(ssd);
    }

    @Override
    public Optional<Ssd> getOne(long id) {
        return ssdRepository.findById(id);
    }

    @Override
    public List<Ssd> getAll() {
        return ssdRepository.findAll();
    }

    @Override
    public Ssd update(Ssd ssd, long id) {
        Ssd temp = ssdRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(ssd.getName());
            temp.setProducer(ssd.getProducer());
            temp.setStorageSize(ssd.getStorageSize());
            temp.setFormFactor(ssd.getFormFactor());
            temp.setStorageInterface(ssd.getStorageInterface());
            temp.setBufferSize(ssd.getBufferSize());
            temp.setReadingSpeed(ssd.getReadingSpeed());
            temp.setWritingSpeed(ssd.getWritingSpeed());
            temp.setCellsType(ssd.getCellsType());
            temp.setDescription(ssd.getDescription());
            temp.setRecommendedPrice(ssd.getRecommendedPrice());
            temp.setPerformanceLevel(ssd.getPerformanceLevel());
            return ssdRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        ssdRepository.deleteById(id);
    }
}
