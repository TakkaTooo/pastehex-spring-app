package ru.rsreu.pastehex.services.admin;

import ru.rsreu.pastehex.forms.UserUpdateForm;

public interface AdminPanelService {
    void updateUser(Long id, UserUpdateForm userUpdateForm);
}
