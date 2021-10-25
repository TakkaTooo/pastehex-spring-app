package ru.rsreu.pastehex.services.state;

import ru.rsreu.pastehex.models.user.State;

import java.util.List;

public interface StateService {
    State findById(Long id);

    State findByTitle(String title);

    List<State> findAll();
}
