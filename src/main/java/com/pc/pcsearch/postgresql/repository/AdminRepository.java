package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
