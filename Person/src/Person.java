import java.util.Objects;

public class Person {

    private String firstname;
    private String lastname;
    private String Laptop;

    public Person(String firstname, String lastname, String laptop) {
        this.firstname = firstname;
        this.lastname = lastname;
        Laptop = laptop;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(Laptop, person.Laptop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, Laptop);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Laptop='" + Laptop + '\'' +
                '}';
    }
}
