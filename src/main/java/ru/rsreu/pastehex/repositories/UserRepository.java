package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.rsreu.pastehex.models.user.Role;
import ru.rsreu.pastehex.models.user.State;
import ru.rsreu.pastehex.models.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Transactional
    @Modifying
    @Query("UPDATE User user set user.role = ?2, user.state = ?3 where user.id = ?1")
    void updateRoleAndStateById(Long id, Role role, State state);
}