package by.andreiblinets.entity;

public class Payment {

    private long id;
    private long idUser;
    private double summa;

    public Payment(long id, long idUser, double summa) {
        this.id = id;
        this.idUser = idUser;
        this.summa = summa;
    }

    public Payment() {
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

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != payment.id) return false;
        if (idUser != payment.idUser) return false;
        return Double.compare(payment.summa, summa) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", summa=" + summa +
                '}';
    }
}
