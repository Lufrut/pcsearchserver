package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageInterface;

import java.util.List;
import java.util.Optional;

public interface StorageInterfaceService {
    StorageInterface create(StorageInterface storageInterface);

    Optional<StorageInterface> getOne(long id);

    List<StorageInterface> getAll();

    StorageInterface update(StorageInterface storageInterface, long id);

    void delete(long id);
}
