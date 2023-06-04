package com.pc.pcsearch.postgresql.repository.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}
