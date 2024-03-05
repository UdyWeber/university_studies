// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vaca v = new Vaca("Filomena", 3, 420.69);
        System.out.println("Filomena é adulta: " + v.isAdulto());
        System.out.println("A vaca faz " + v.emitirSom());
    }
}