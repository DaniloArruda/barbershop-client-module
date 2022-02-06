package barbershop.clientmodule.domain.value_object;

public class Name {
    public final String firstName;
    public final String lastName;

    public Name(String firstName, String lastName) throws RuntimeException {
        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty())
            throw new RuntimeException();

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        var otherName = (Name) obj;
        return this.firstName.equals(otherName.firstName) && this.lastName.equals(otherName.lastName);
    }
}
