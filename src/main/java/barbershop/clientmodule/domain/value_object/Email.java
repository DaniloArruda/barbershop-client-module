package barbershop.clientmodule.domain.value_object;

import barbershop.clientmodule.domain.value_object.exception.EmailException;

public class Email {
    public final String value;

    public Email(String value) {
        if (value == null)
            throw new EmailException(value);

        if (!value.contains("@"))
            throw new EmailException(value);

        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
