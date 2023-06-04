package com.pc.pcsearch.postgresql.repository.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPUTechRepository extends JpaRepository<CPUTech, Long> {
}
