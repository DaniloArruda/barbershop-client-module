package barbershop.clientmodule.port.usecase;

public interface UseCase<TRequest, TResponse> {
    public TResponse handle(TRequest request);
}
