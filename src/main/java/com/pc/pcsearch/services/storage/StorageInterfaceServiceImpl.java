package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageInterface;
import com.pc.pcsearch.postgresql.repository.storage.StorageInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageInterfaceServiceImpl implements StorageInterfaceService{
    @Autowired
    StorageInterfaceRepository repository;
    @Override
    public StorageInterface create(StorageInterface storageInterface) {
        return repository.save(storageInterface);
    }

    @Override
    public Optional<StorageInterface> getOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<StorageInterface> getAll() {
        return repository.findAll();
    }

    @Override
    public StorageInterface update(StorageInterface storageInterface, long id) {
        StorageInterface temp = repository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(storageInterface.getName());
            return repository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
