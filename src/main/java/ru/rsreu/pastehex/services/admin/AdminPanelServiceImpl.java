package ru.rsreu.pastehex.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.forms.UserUpdateForm;
import ru.rsreu.pastehex.services.role.RoleService;
import ru.rsreu.pastehex.services.state.StateService;
import ru.rsreu.pastehex.services.user.UserService;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {
    private final UserService userService;

    private final RoleService roleService;

    private final StateService stateService;

    @Autowired
    public AdminPanelServiceImpl(UserService userService, RoleService roleService, StateService stateService) {
        this.userService = userService;
        this.roleService = roleService;
        this.stateService = stateService;
    }

    @Override
    public void updateUser(Long id, UserUpdateForm userUpdateForm) {
        userService.updateRoleAndStateById(id,
                roleService.findByTitle(userUpdateForm.getRoleTitle()),
                stateService.findByTitle(userUpdateForm.getStateTitle()));
    }
}
