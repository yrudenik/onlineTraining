package com.epam.training.onlineTraining.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Identifable, Serializable {

    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String LOGIN = "login";
    public static final String ROLE = "role";

    private final Long id;
    private final String name;
    private final String surname;
    private final String login;
    private final UserRole role;

    public User(Long id, String name, String surname, String login, UserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.role = role;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (!Objects.equals(id, user.id)) {
            return false;
        }
        if (!Objects.equals(name, user.name)) {
            return false;
        }
        if (!Objects.equals(surname, user.surname)) {
            return false;
        }
        if (!Objects.equals(login, user.login)) {
            return false;
        }
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
