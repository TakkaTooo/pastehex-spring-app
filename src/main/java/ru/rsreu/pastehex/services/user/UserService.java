package ru.rsreu.pastehex.services.user;

import ru.rsreu.pastehex.models.user.Role;
import ru.rsreu.pastehex.models.user.State;
import ru.rsreu.pastehex.models.user.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    List<User> findAllOrderByIdAsc();

    void save(User user);

    void updateRoleAndStateById(Long id, Role role, State state);

    List<User> findAllByPageNumber(int pageNumber, int pageSize);
}
