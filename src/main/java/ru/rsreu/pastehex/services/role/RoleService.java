package ru.rsreu.pastehex.services.role;

import ru.rsreu.pastehex.models.user.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);

    Role findByTitle(String title);

    List<Role> findAllWithoutAdminRole();
}
