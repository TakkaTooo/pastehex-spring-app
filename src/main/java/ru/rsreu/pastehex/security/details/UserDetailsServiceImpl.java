package ru.rsreu.pastehex.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.repositories.StateRepository;
import ru.rsreu.pastehex.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final StateRepository stateRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, StateRepository stateRepository) {
        this.userRepository = userRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(this.stateRepository,
                userRepository.findByLogin(username).orElseThrow(IllegalArgumentException::new));
    }
}
