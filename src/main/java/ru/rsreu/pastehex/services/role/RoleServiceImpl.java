package ru.rsreu.pastehex.services.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.models.user.Role;
import ru.rsreu.pastehex.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Role findByTitle(String title) {
        return roleRepository.findByTitle(title).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Role> findAllWithoutAdminRole() {
        return roleRepository.findAllWithoutAdminRole();
    }
}
