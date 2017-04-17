package by.andreiblinets.dao.entity;

import by.andreiblinets.dao.entity.enums.UserRole;


public class User {

    private long id;
    private String login;
    private String password;
    private String name;
    private UserRole userRole;

    public User(long id, String login, String password, String name, UserRole userRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getName().equals(user.getName())) return false;
        return getUserRole() == user.getUserRole();
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getUserRole().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", userRole=").append(userRole);
        sb.append('}');
        return sb.toString();
    }
}
