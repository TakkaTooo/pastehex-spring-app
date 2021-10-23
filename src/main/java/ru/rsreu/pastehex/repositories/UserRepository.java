package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
}
