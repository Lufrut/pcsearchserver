package com.pc.pcsearch.services;

import com.pc.pcsearch.models.build_pc.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Optional<User> findById(long id);

    List<User> getAll();

    User update(User user, long id);

    void delete(long id);
}
