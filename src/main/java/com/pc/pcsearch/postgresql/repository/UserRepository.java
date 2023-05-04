package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.build_pc.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
