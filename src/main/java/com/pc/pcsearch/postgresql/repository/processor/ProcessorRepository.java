package com.pc.pcsearch.postgresql.repository.processor;

import com.pc.pcsearch.models.buildpc.processor.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepository extends JpaRepository<Processor, Long> {
}
