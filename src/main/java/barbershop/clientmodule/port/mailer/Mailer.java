package barbershop.clientmodule.port.mailer;

public interface Mailer {
    public void send(String destination, String message);
}
