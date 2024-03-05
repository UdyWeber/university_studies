import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Carro c = new Carro(100, 2);
        Scanner s = new Scanner(System.in);
        String option;

        do {
            System.out.printf(
                """
                -----------------------------
                O que o carro vai fazer?
                
                1 - Andar
                2 - Abastecer
                3 - Distancia possivel
                4 - Sair
                -----------------------------
                Qtd Gasolina: %d
                """,
                c.getQtdGasolina()
            );

            option = s.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println("Digite quantos KM vamos andar");
                    int km = Integer.parseInt(s.nextLine());

                    try {
                        c.andar(km);
                    } catch (TanqueVazioException | TanqueInsuficienteException e) {
                        System.out.println(e);
                    }
                }
                case "2" -> {
                    System.out.println("Quanto voce deseja abastecer");
                    int qtd = Integer.parseInt(s.nextLine());

                    try {
                        c.encherTanque(qtd);
                    } catch (TanqueCheioException e) {
                        System.out.println(e);
                    }
                }
                case "3" -> System.out.println("Distancia possivel para percorrer: " + c.distanciaPossivel() + "KM");
                case "4" -> System.out.println("Até a próxima!!");
                default -> System.out.println("Opção Invalida!");
            }
        } while (!option.trim().equalsIgnoreCase("4"));
    }
}