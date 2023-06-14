package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicUserServiceImpl implements PublicUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> getOne(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user, long id) {
        User temp = userRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(user.getName());
            temp.setEmail(user.getEmail());
            temp.setUsername(user.getUsername()); // possible bug with jwt tokens but should works
            return userRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
