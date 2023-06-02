package com.pc.pcsearch.postgresql.repository.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageInterfaceRepository extends JpaRepository<StorageInterface, Long> {
}
