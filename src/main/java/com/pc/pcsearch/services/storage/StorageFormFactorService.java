package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageFormFactor;

import java.util.List;
import java.util.Optional;

public interface StorageFormFactorService {
    StorageFormFactor create(StorageFormFactor storageFormFactor);

    Optional<StorageFormFactor> getOne(long id);

    List<StorageFormFactor> getAll();

    StorageFormFactor update(StorageFormFactor storageFormFactor, long id);

    void delete(long id);
}
