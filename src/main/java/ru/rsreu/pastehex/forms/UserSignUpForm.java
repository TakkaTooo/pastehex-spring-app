package ru.rsreu.pastehex.forms;

import lombok.Data;

@Data
public class UserSignUpForm {
    private String login;
    private String password;
    private String email;
}
