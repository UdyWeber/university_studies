import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Pessoa[] personNames = {
            new Pessoa("Emily"),
            new Pessoa("Alexander"),
            new Pessoa("Olivia"),
            new Pessoa("Ethan"),
            new Pessoa("Sophia"),
            new Pessoa("Liam"),
            new Pessoa("Mia"),
            new Pessoa("Noah"),
            new Pessoa("Taylor"),
            new Pessoa("Aiden"),
            new Pessoa("Isabella"),
            new Pessoa("Lucas"),
            new Pessoa("Thomas"),
            new Pessoa("Mason"),
            new Pessoa("Harper"),
            new Pessoa("Scott"),
            new Pessoa("Amelia"),
            new Pessoa("Henry"),
            new Pessoa("Abigail"),
            new Pessoa("William")
        };

        ControleTeleSena c = new ControleTeleSena(personNames);
        c.sorteio();
    }
}