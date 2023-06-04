package com.pc.pcsearch.postgresql.repository.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUGeneration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPUGenerationRepository extends JpaRepository<CPUGeneration, Long> {
}
