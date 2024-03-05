public class Vaca extends Animal {
    public Vaca(String nome, int idade, double valor) {
        super(nome, idade, valor);
    }

    @Override
    public String emitirSom() {
        return "MUUUUUUUUUUUU";
    }

    @Override
    public Boolean isAdulto() {
        return this.getIdade() > 4;
    }
}
