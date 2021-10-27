package ru.rsreu.pastehex.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.models.user.Role;
import ru.rsreu.pastehex.models.user.State;
import ru.rsreu.pastehex.models.user.User;
import ru.rsreu.pastehex.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllOrderByIdAsc() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateRoleAndStateById(Long id, Role role, State state) {
        userRepository.updateRoleAndStateById(id, role, state);
    }

    @Override
    public List<User> findAllByPageNumber(int pageNumber, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNumber,
                pageSize,
                Sort.by("id"))).getContent();
    }
}
