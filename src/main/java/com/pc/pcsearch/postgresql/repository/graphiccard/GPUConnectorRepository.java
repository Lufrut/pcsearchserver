package com.pc.pcsearch.postgresql.repository.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUConnector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPUConnectorRepository extends JpaRepository<GPUConnector, Long> {
}
