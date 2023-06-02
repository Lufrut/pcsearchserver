package com.pc.pcsearch.postgresql.repository.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageFormFactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageFormFactorRepository extends JpaRepository<StorageFormFactor, Long> {
}
