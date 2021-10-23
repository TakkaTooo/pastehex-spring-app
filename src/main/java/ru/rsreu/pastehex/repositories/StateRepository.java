package ru.rsreu.pastehex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.pastehex.models.user.State;

public interface StateRepository extends JpaRepository<State, Long> {
}
