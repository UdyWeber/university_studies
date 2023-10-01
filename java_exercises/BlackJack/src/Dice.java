import java.util.Random;

public class Dice {
    private String color;

    public Dice(String color) {
        this.color = color;
    }

    public int jogaDado() {
        Random random = new Random();

        int aleatorio = random.nextInt(1, 7);

        if (color.equals("vermelho") && aleatorio == 6) {
            return 12;
        }

        return aleatorio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
