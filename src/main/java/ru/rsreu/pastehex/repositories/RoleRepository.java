package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rsreu.pastehex.models.user.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTitle(String title);

    @Query(value = "FROM Role WHERE title <> 'ADMIN'")
    List<Role> findAllWithoutAdminRole();
}
