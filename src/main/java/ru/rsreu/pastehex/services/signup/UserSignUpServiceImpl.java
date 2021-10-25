package ru.rsreu.pastehex.services.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rsreu.pastehex.forms.UserForm;
import ru.rsreu.pastehex.models.user.User;
import ru.rsreu.pastehex.repositories.RoleRepository;
import ru.rsreu.pastehex.repositories.StateRepository;
import ru.rsreu.pastehex.repositories.UserRepository;
import ru.rsreu.pastehex.services.folder.FolderService;
import ru.rsreu.pastehex.services.paste.settings.PasteSettingsService;

@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final PasteSettingsService pasteSettingsService;

    private final FolderService folderService;

    private final RoleRepository roleRepository;

    private final StateRepository stateRepository;

    @Autowired
    public UserSignUpServiceImpl(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 PasteSettingsService pasteSettingsService,
                                 FolderService folderService,
                                 RoleRepository roleRepository,
                                 StateRepository stateRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.pasteSettingsService = pasteSettingsService;
        this.folderService = folderService;
        this.roleRepository = roleRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .login(userForm.getLogin())
                .password(hashPassword)
                .email(userForm.getEmail())
                .role(roleRepository.getById(3L))
                .state(stateRepository.getById(1L))
                .defaultPasteSettings(pasteSettingsService.saveDefaultPasteSettings())
                .build();
        userRepository.save(user);
        folderService.saveDefaultFolder(user);
    }
}
