public class TanqueCheioException extends Exception {
    private final String message;

    public TanqueCheioException(int qtdPossivel) {
        this.message = String.format("Quantidade ultrapassa o maximo do tanque, quantidade possivel: %d", qtdPossivel);
    }

    @Override
    public String toString() {
        return message;
    }
}
