public class Player {
    private  String name;
    private int score;
    private Dice redDice, whiteDice;

    public Player(String name, Dice redDice, Dice whiteDice) {
        this.name = name;
        this.score = 0;
        this.redDice = redDice;
        this.whiteDice = whiteDice;
    }

    public void rollDices() {
        System.out.println(name + " está jogando os dados...\n");

        int firstValue = whiteDice.jogaDado();

        System.out.println("Valor do dado branco: " + firstValue);
        this.score += firstValue;

        int secondValue = redDice.jogaDado();

        System.out.println("Valor do dado vermelho: " + secondValue);
        this.score += secondValue;
    }

    public String getName() {
        return name;
    }

    public Dice getRedDice() {
        return redDice;
    }

    public Dice getWhiteDice() {
        return whiteDice;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRedDice(Dice redDice) {
        this.redDice = redDice;
    }

    public void setWhiteDice(Dice whiteDice) {
        this.whiteDice = whiteDice;
    }
}
