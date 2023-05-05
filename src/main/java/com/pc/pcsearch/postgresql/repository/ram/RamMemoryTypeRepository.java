package com.pc.pcsearch.postgresql.repository.ram;

import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RamMemoryTypeRepository extends JpaRepository<RamMemoryType, Long> {
}
