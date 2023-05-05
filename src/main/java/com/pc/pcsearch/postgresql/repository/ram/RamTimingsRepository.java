package com.pc.pcsearch.postgresql.repository.ram;

import com.pc.pcsearch.models.buildpc.ram.RamTimings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamTimingsRepository extends JpaRepository<RamTimings, Long> {
}
