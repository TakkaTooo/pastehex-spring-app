package ru.rsreu.pastehex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.forms.UserForm;
import ru.rsreu.pastehex.models.Role;
import ru.rsreu.pastehex.models.State;
import ru.rsreu.pastehex.models.User;
import ru.rsreu.pastehex.repositories.UserRepository;

@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserSignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .login(userForm.getLogin())
                .password(hashPassword)
                .email(userForm.getEmail())
                .role(Role.builder().id(3L).title("USER").build())
                .state(State.builder().id(1L).title("ACTIVE").build())
                .build();
        userRepository.save(user);
    }
}
