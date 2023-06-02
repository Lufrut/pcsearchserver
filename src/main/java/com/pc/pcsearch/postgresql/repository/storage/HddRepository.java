package com.pc.pcsearch.postgresql.repository.storage;

import com.pc.pcsearch.models.buildpc.storage.Hdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HddRepository extends JpaRepository<Hdd, Long> {
}
