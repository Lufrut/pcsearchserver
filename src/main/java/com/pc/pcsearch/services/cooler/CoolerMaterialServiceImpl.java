package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerMaterial;
import com.pc.pcsearch.postgresql.repository.cooler.CoolerMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoolerMaterialServiceImpl implements CoolerMaterialService{
    @Autowired
    CoolerMaterialRepository coolerMaterialRepository;
    @Override
    public CoolerMaterial create(CoolerMaterial coolerMaterial) {
        return coolerMaterialRepository.save(coolerMaterial);
    }

    @Override
    public Optional<CoolerMaterial> getOne(long id) {
        return coolerMaterialRepository.findById(id);
    }

    @Override
    public List<CoolerMaterial> getAll() {
        return coolerMaterialRepository.findAll();
    }

    @Override
    public CoolerMaterial update(CoolerMaterial coolerMaterial, long id) {
        CoolerMaterial temp = coolerMaterialRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setMaterial(coolerMaterial.getMaterial());
            return coolerMaterialRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        coolerMaterialRepository.deleteById(id);
    }
}
