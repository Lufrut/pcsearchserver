package com.pc.pcsearch.services;

import com.pc.pcsearch.models.build_pc.Admin;
import com.pc.pcsearch.postgresql.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findById(long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin update(Admin admin, long id) {
        Admin temp = adminRepository.findById(id).orElseThrow();
        if(Objects.nonNull(admin.getEmail())
        && !"".equalsIgnoreCase(admin.getEmail())
        ){
            temp.setEmail(admin.getEmail());
        }
        if(Objects.nonNull(admin.getLogin())
                && !"".equalsIgnoreCase(admin.getLogin())
        ){
            temp.setLogin(admin.getLogin());
        }

        return adminRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        adminRepository.deleteById(id);
    }
}
