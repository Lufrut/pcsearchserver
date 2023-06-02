package com.pc.pcsearch.postgresql.repository.pccase;

import com.pc.pcsearch.models.buildpc.pccase.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
