package com.pc.pcsearch.postgresql.repository.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUMemoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPUMemoryTypeRepository extends JpaRepository<GPUMemoryType, Long> {
}
