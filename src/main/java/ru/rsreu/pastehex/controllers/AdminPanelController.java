package ru.rsreu.pastehex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.pastehex.forms.UserUpdateForm;
import ru.rsreu.pastehex.services.admin.AdminPanelService;
import ru.rsreu.pastehex.services.role.RoleService;
import ru.rsreu.pastehex.services.state.StateService;
import ru.rsreu.pastehex.services.user.UserService;


@Controller
public class AdminPanelController {
    private final UserService userService;

    private final RoleService roleService;

    private final StateService stateService;

    private final AdminPanelService adminPanelService;

    @Autowired
    public AdminPanelController(UserService userService,
                                RoleService roleService,
                                StateService stateService,
                                AdminPanelService adminPanelService) {
        this.userService = userService;
        this.roleService = roleService;
        this.stateService = stateService;
        this.adminPanelService = adminPanelService;
    }

    @GetMapping("/admin")
    public String getAdminPanelPage(Model model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return "admin";
    }

    @GetMapping("/admin/users")
    public String getUsersPage(Model model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("users", userService.findAllOrderByIdAsc());
        return "admin_users";
    }

    @GetMapping("admin/users/{id}")
    public String getEditUserPage(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.findAllWithoutAdminRole());
        model.addAttribute("states", stateService.findAll());
        return "user_edit";
    }

    @PostMapping("admin/users/edit/{id}")
    public String updateUser(@PathVariable Long id, UserUpdateForm userUpdateForm) {
        adminPanelService.updateUser(id, userUpdateForm);
        return "redirect:/admin/users";
    }
}
