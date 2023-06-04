package com.pc.pcsearch.postgresql.repository.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUPcieVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPUPcieVersionRepository extends JpaRepository<CPUPcieVersion, Long> {
}
