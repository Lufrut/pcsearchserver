package com.pc.pcsearch.postgresql.repository.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUTechnologies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPUTechnologiesRepository extends JpaRepository<GPUTechnologies, Long> {
}
