package by.andreiblinets.dto;

public class UserDTO {
    private long id;
    private String name;
    private String rolesUser;

    public UserDTO(long id, String name, String rolesUser) {
        this.id = id;
        this.name = name;
        this.rolesUser = rolesUser;
    }

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolesUser() {
        return rolesUser;
    }

    public void setRolesUser(String rolesUser) {
        this.rolesUser = rolesUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != userDTO.id) return false;
        if (name != null ? !name.equals(userDTO.name) : userDTO.name != null) return false;
        return rolesUser == userDTO.rolesUser;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rolesUser != null ? rolesUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rolesUser=" + rolesUser +
                '}';
    }
}
