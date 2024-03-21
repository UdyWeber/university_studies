import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private final static String DEFAULT_PATH = "./maze_solver/src/";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo de onde você deseja criar o labirinto: ");
        String fileName = s.nextLine();

        Labirinto l = new Labirinto();
        System.out.println("Carregando labirinto...");
        Peca[][] lab = l.carregaLabirinto(DEFAULT_PATH+fileName);

        String message = l.labirinto(lab)
            ? "Existe um caminho para o labirinto"
            : "Não existe um caminho para o labirinto";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(DEFAULT_PATH + "saidaLabirinto.txt");
        } catch (IOException e) {
            System.out.println("Não foi possivel escrever no arquivo");
        }

        System.out.println("Escrevendo resultados...");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(message);
        printWriter.close();
    }
}