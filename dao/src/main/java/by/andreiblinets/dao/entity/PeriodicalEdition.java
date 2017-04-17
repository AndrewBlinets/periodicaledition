package by.andreiblinets.dao.entity;

public class PeriodicalEdition {

    private long id;
    private String name;
    private double price;

    public PeriodicalEdition(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public PeriodicalEdition() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodicalEdition that = (PeriodicalEdition) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PeriodicalEdition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
