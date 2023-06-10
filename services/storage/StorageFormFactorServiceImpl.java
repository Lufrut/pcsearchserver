package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageFormFactor;
import com.pc.pcsearch.postgresql.repository.storage.StorageFormFactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageFormFactorServiceImpl implements  StorageFormFactorService{
    @Autowired
    StorageFormFactorRepository storageFormFactorRepository;

    @Override
    public StorageFormFactor create(StorageFormFactor storageFormFactor) {
        return storageFormFactorRepository.save(storageFormFactor);
    }

    @Override
    public Optional<StorageFormFactor> getOne(long id) {
        return storageFormFactorRepository.findById(id);
    }

    @Override
    public List<StorageFormFactor> getAll() {
        return storageFormFactorRepository.findAll();
    }

    @Override
    public StorageFormFactor update(StorageFormFactor storageFormFactor, long id) {
        StorageFormFactor temp = storageFormFactorRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(storageFormFactor.getName());
            return storageFormFactorRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        storageFormFactorRepository.deleteById(id);
    }
}
