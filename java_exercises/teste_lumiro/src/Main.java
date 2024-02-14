import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cerebro c = new Cerebro();
        Scanner s = new Scanner(System.in);

        String op;

        do  {
            System.out.println(
                """
                1 - Comer
                2 - Falar
                3 - Sair
                """
            );
            op = s.nextLine();

            switch (op) {
                case "1" -> c.comer();
                case "2" -> c.falar();
            }
        } while (!op.equals("3"));
    }
}