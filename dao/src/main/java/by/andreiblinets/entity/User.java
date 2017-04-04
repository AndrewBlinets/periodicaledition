package by.andreiblinets.entity;

import by.andreiblinets.entity.enumus.RolesUser;

public class User {

    private long id;
    private String login;
    private String password;
    private String name;
    private RolesUser rolesUser;

    public User(long id, String login, String password, String name, RolesUser rolesUser) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.rolesUser = rolesUser;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RolesUser getRolesUser() {
        return rolesUser;
    }

    public void setRolesUser(RolesUser rolesUser) {
        this.rolesUser = rolesUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return rolesUser == user.rolesUser;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rolesUser != null ? rolesUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", rolesUser=" + rolesUser +
                '}';
    }
}
