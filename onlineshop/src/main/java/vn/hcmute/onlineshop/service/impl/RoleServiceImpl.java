package vn.hcmute.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmute.onlineshop.entity.Role;
import vn.hcmute.onlineshop.repository.RoleRepository;
import vn.hcmute.onlineshop.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
