package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.User;

import java.util.Optional;

public interface PublicUserService {

        public Optional<User> getOne(long id);

        public User update(User user, long id);

        public void delete(long id);
}
