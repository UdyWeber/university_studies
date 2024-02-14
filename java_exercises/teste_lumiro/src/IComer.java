public class IComer implements IState{
    @Override
    public void comer() {
        System.out.println("Estou terminando de comer");
    }

    @Override
    public void falar() {
        System.out.println("Estou comendo por isso não posso falar");
    }
}
