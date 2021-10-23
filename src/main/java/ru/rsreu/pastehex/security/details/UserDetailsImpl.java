package ru.rsreu.pastehex.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.rsreu.pastehex.models.User;
import ru.rsreu.pastehex.repositories.StateRepository;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    private final StateRepository stateRepository;

    private final User user;

    public UserDetailsImpl(StateRepository stateRepository, User user) {
        this.stateRepository = stateRepository;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getTitle()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals(stateRepository.findById(2L).get());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public boolean isEnabled() {
        return user.getState().equals(stateRepository.findById(1L).get());
    }
}
