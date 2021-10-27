package ru.rsreu.pastehex.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.forms.UserUpdateForm;
import ru.rsreu.pastehex.services.pages.ElementsPagesDisplayConfiguration;
import ru.rsreu.pastehex.services.pages.ViewablePageNumbersGenerator;
import ru.rsreu.pastehex.services.role.RoleService;
import ru.rsreu.pastehex.services.state.StateService;
import ru.rsreu.pastehex.services.user.UserService;

import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {
    @Value("${admin.users.page.size}")
    private int usersPageSize;

    @Value("${admin.users.pages.viewable.quantity}")
    private int usersPagesViewableQuantity;

    private final UserService userService;

    private final RoleService roleService;

    private final StateService stateService;

    @Autowired
    public AdminPanelServiceImpl(
            UserService userService,
            RoleService roleService,
            StateService stateService) {
        this.userService = userService;
        this.roleService = roleService;
        this.stateService = stateService;
    }

    private ElementsPagesDisplayConfiguration buildAdminUsersPagesSettings() {
        return ElementsPagesDisplayConfiguration
                .builder()
                .viewablePagesQuantity(usersPagesViewableQuantity)
                .pageSize(usersPageSize)
                .elementsQuantity(userService.findAll().size())
                .build();
    }

    @Override
    public void updateUser(Long id, UserUpdateForm userUpdateForm) {
        userService.updateRoleAndStateById(id,
                roleService.findByTitle(userUpdateForm.getRoleTitle()),
                stateService.findByTitle(userUpdateForm.getStateTitle()));
    }

    @Override
    public List<Integer> getViewablePagesNumbers(int currentPageNumber) {
        return new ViewablePageNumbersGenerator(buildAdminUsersPagesSettings())
                .getViewablePagesNumbers(currentPageNumber);
    }

    @Override
    public int getUsersPageSize() {
        return usersPageSize;
    }
}
