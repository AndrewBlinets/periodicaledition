package by.andreiblinets.dao.entity;

public class Subscription {

    private long id;
    private long idUser;
    private long idPeriodicalEdition;

    public Subscription(long id, long idUser, long idPeriodicalEdition) {
        this.id = id;
        this.idUser = idUser;
        this.idPeriodicalEdition = idPeriodicalEdition;
    }

    public Subscription() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdPeriodicalEdition() {
        return idPeriodicalEdition;
    }

    public void setIdPeriodicalEdition(long idPeriodicalEdition) {
        this.idPeriodicalEdition = idPeriodicalEdition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        return idPeriodicalEdition == that.idPeriodicalEdition;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (int) (idPeriodicalEdition ^ (idPeriodicalEdition >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idPeriodicalEdition=" + idPeriodicalEdition +
                '}';
    }
}
