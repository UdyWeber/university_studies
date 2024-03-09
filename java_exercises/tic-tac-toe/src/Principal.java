import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Diga o tamanho do grid");

        int tamanhoTabuleiro;

        while (true) {
            try {
                tamanhoTabuleiro = Integer.parseInt(s.nextLine());

                if (tamanhoTabuleiro < 1) {
                    System.out.println("[ERRO] Tamanho do grid deve ser maior q zero, tente novamente!");
                    continue;
                }

                break;
            } catch (NumberFormatException ignored) {
                System.out.println("[ERRO] Tamanho do grid deve ser um número, tente novamente!");
            }
        }

        JogoDaVelha g = new JogoDaVelha(tamanhoTabuleiro);
        g.play();
    }
}