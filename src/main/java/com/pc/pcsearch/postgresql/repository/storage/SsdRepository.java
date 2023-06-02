package com.pc.pcsearch.postgresql.repository.storage;

import com.pc.pcsearch.models.buildpc.storage.Ssd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsdRepository extends JpaRepository<Ssd, Long> {
}
