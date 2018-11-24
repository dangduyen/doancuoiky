package vn.hcmute.onlineshop.model.dto;

import vn.hcmute.onlineshop.entity.Role;

import java.io.Serializable;
import java.util.List;

public class AccountDto implements Serializable {
    private long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private List<RoleDto> roles;

    public AccountDto() {
    }

    public AccountDto(long id, String username, String password, String name, String phone, String email, List<RoleDto> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roles = roles;
    }


    public AccountDto(long id, String username, String password, String name, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
