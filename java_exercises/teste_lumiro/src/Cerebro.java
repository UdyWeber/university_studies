public class Cerebro {
    private IState estado;

    Cerebro() {
        estado = new IVazio();
    }

    public void comer() {
        estado.comer();

        switch (estado.getClass().getSimpleName()) {
            case "IVazio", "IFalar" -> estado = new IComer();
            case "IComer" -> estado = new IVazio();
        }
    }

    public void falar() {
        estado.falar();

        switch (estado.getClass().getSimpleName()) {
            case "IVazio" -> estado = new IFalar();
            case "IComer" -> estado = new IVazio();
        }
    }
}
