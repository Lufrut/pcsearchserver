package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
