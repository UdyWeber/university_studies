public class TanqueInsuficienteException extends Exception {
    private final String message;

    public TanqueInsuficienteException() {
        this.message = "O tanque do carro é insuficiente";
    }

    @Override
    public String toString() {
        return message;
    }
}
