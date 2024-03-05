// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Universidade u = new Universidade("Unisinos", "Lugar onde fica ela", 10, 1000);
        u.printInfo();

        Universidade[] universidades = new Universidade[3];

        universidades[0] = u;

        Publica p = new Publica(u, 1000);
        p.printInfo();

        universidades[1] = p;

        Privada pv = new Privada(u, 958.91);
        pv.printInfo();

        universidades[2] = pv;

        for (Universidade un : universidades) {
            String tipo = switch (un.getClass().getSimpleName()) {
                case "Publica" -> "É uma universidade pública";
                case "Privada" -> "É uma universidade privada";
                default -> "É uma universidade comum";
            };
            System.out.println(tipo);
        }
    }
}