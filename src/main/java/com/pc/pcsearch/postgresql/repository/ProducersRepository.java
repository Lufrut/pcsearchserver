package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.Producers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducersRepository extends JpaRepository<Producers, Long> {
}
