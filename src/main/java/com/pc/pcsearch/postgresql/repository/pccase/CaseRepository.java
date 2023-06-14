package com.pc.pcsearch.postgresql.repository.pccase;

import com.pc.pcsearch.models.buildpc.pccase.PCCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<PCCase, Long> {
}
