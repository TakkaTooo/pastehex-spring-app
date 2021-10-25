package ru.rsreu.pastehex.services.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.models.user.State;
import ru.rsreu.pastehex.repositories.StateRepository;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State findById(Long id) {
        return stateRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public State findByTitle(String title) {
        return stateRepository.findByTitle(title).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }
}
