package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.build_pc.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
