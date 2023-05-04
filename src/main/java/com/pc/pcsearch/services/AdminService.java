package com.pc.pcsearch.services;

import com.pc.pcsearch.models.build_pc.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin create(Admin admin);
    Optional<Admin> findById(long id);

    List<Admin> getAll();

    Admin update(Admin admin, long id);

    void delete(long id);
}
