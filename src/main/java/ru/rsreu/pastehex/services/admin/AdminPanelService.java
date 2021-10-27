package ru.rsreu.pastehex.services.admin;

import ru.rsreu.pastehex.forms.UserUpdateForm;

import java.util.List;

public interface AdminPanelService {
    void updateUser(Long id, UserUpdateForm userUpdateForm);

    List<Integer> getViewablePagesNumbers(int currentPageNumber);

    int getUsersPageSize();
}

