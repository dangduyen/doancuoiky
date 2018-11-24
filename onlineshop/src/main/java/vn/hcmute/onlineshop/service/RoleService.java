package vn.hcmute.onlineshop.service;

import vn.hcmute.onlineshop.entity.Role;

public interface RoleService  {
    Role findByName(String name);
    Role saveRole(Role role);
}
