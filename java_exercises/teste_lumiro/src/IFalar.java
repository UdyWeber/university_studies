public class IFalar implements IState{
    @Override
    public void comer() {
        System.out.println("Vou começar a comer");
    }

    @Override
    public void falar() {
        System.out.println("Hello Jessica");
    }
}
