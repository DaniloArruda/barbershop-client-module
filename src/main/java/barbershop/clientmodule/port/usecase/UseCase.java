package barbershop.clientmodule.port.usecase;

public interface UseCase<TRequest, TResponse> {
    public TResponse perform(TRequest request);
}
