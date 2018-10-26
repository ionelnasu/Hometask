import java.util.Objects;

public class Laptop {

    private String name;
    int priceTag;

    public Laptop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return priceTag == laptop.priceTag &&
                Objects.equals(name, laptop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceTag);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", priceTag=" + priceTag +
                '}';
    }

}
