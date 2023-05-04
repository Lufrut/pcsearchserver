package com.pc.pcsearch.services;

import com.pc.pcsearch.models.build_pc.Admin;
import com.pc.pcsearch.models.build_pc.User;
import com.pc.pcsearch.postgresql.repository.AdminRepository;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user, long id) {
        User temp = userRepository.findById(id).orElseThrow();
        if(Objects.nonNull(user.getName())
                && !"".equalsIgnoreCase(user.getName())
        ){
            temp.setName(user.getName());
        }
        if(Objects.nonNull(user.getEmail())
                && !"".equalsIgnoreCase(user.getEmail())
        ){
            temp.setEmail(user.getEmail());
        }
        if(Objects.nonNull(user.getLogin())
                && !"".equalsIgnoreCase(user.getLogin())
        ){
            temp.setLogin(user.getLogin());
        }

        return userRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
