package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
