import java.util.Random;

public class Dado {
    private String cor;

    public Dado(String color) {
        this.cor = color;
    }

    /**
     * Roda o dado e devolve o valor randomico tirado de 1 a 6.
     *
     * Caso o dado seja vermelho, e o valor randomico seja 6 o dobro será retornado.
     *
     * @return int
     */
    public int jogaDado() {
        Random random = new Random();

        int aleatorio = random.nextInt(1, 7);

        if (cor.equals("vermelho") && aleatorio == 6) {
            return 12;
        }

        return aleatorio;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
