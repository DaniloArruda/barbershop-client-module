package barbershop.clientmodule.domain.value_object.exception;

public class EmailException extends RuntimeException {
    public EmailException(String email) {
        super("Invalid email: " + email);
    }
}
