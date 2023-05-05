package com.pc.pcsearch.postgresql.repository.ram;

import com.pc.pcsearch.models.buildpc.ram.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {
}
