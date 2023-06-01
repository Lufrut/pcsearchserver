package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.postgresql.repository.cooler.CoolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoolerServiceImpl implements CoolerService{
    @Autowired
    CoolerRepository coolerRepository;
    @Override
    public Cooler create(Cooler cooler) {
        return coolerRepository.save(cooler);
    }

    @Override
    public Optional<Cooler> getOne(long id) {
        return coolerRepository.findById(id);
    }

    @Override
    public List<Cooler> getAll() {
        return coolerRepository.findAll();
    }

    @Override
    public Cooler update(Cooler cooler, long id) {
        Cooler temp = coolerRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(cooler.getName());
            temp.setProducer(cooler.getProducer());
            temp.setSocket(cooler.getSocket());
            temp.setMaterial(cooler.getMaterial());
            temp.setMaxTdp(cooler.getMaxTdp());
            temp.setThermalTubes(cooler.getThermalTubes());
            temp.setDescription(cooler.getDescription());
            temp.setRecommendedPrice(cooler.getRecommendedPrice());
            temp.setPerformanceLevel(cooler.getPerformanceLevel());
            return coolerRepository.save(temp);

        } else return null;

    }

    @Override
    public void delete(long id) {
        coolerRepository.deleteById(id);
    }
}
