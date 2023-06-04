package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.FormFactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFactorRepository extends JpaRepository<FormFactor, Long> {
}
