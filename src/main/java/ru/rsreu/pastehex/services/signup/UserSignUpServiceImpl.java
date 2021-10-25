package ru.rsreu.pastehex.services.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.forms.UserSignUpForm;
import ru.rsreu.pastehex.models.user.User;
import ru.rsreu.pastehex.services.folder.FolderService;
import ru.rsreu.pastehex.services.paste.settings.PasteSettingsService;
import ru.rsreu.pastehex.services.role.RoleService;
import ru.rsreu.pastehex.services.state.StateService;
import ru.rsreu.pastehex.services.user.UserService;

@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final PasteSettingsService pasteSettingsService;

    private final FolderService folderService;

    private final RoleService roleService;

    private final StateService stateService;

    @Autowired
    public UserSignUpServiceImpl(
            PasswordEncoder passwordEncoder,
            UserService userService,
            PasteSettingsService pasteSettingsService,
            FolderService folderService,
            RoleService roleService,
            StateService stateService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.pasteSettingsService = pasteSettingsService;
        this.folderService = folderService;
        this.roleService = roleService;
        this.stateService = stateService;
    }

    @Override
    public void signUp(UserSignUpForm userSignUpForm) {
        String hashPassword = passwordEncoder.encode(userSignUpForm.getPassword());
        User user = User.builder()
                .login(userSignUpForm.getLogin())
                .password(hashPassword)
                .email(userSignUpForm.getEmail())
                .role(roleService.findById(3L))
                .state(stateService.findById(1L))
                .defaultPasteSettings(pasteSettingsService.saveDefaultPasteSettings())
                .build();
        userService.save(user);
        folderService.saveDefaultFolder(user);
    }
}
