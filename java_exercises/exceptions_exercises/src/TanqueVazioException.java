public class TanqueVazioException extends Exception {
    private final String message;

    public TanqueVazioException() {
        this.message = "O tanque do carro está vazio";
    }

    @Override
    public String toString() {
        return message;
    }
}
