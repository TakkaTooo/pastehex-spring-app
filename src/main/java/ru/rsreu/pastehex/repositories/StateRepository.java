package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.user.State;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByTitle(String title);
}
