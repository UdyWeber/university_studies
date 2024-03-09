import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final Scanner s = new Scanner(System.in);

    private static Jogador criaJogador(Marker playerObject) {
        String name = "";

        while (name.trim().equalsIgnoreCase("")) {
            System.out.println("Digite o seu nome jogador");
            name = s.nextLine();
        }

        return new Jogador(name, playerObject);
    }

    private static int pedeTamanhoTabuleiro() {
        System.out.println("Informe o tamanho do tabuleiro");
        int tamanhoTabuleiro;

        while (true) {
            try {
                tamanhoTabuleiro = Integer.parseInt(s.nextLine());

                if (tamanhoTabuleiro < 2) {
                    System.out.println("[ERRO] Tamanho do tabuleiro deve ser maior q zero, tente novamente!");
                    continue;
                }

                return tamanhoTabuleiro;
            } catch (NumberFormatException ignored) {
                System.out.println("[ERRO] Tamanho do tabuleiro deve ser um número, tente novamente!");
            }
        }
    }

    public static int[] pegaCoordenadas() {
        int[] coordenadas = new int[2];
        while (true) {
            System.out.print("Digite as cordenadas entre da sua jogada separado com '-' [EX: 1-2 arg1=linha agr2=coluna]: ");
            String[] result = s.nextLine().trim().split("-");

            try {
                if (result.length < 2) {
                    throw new NumberFormatException();
                }

                coordenadas[0] = Integer.parseInt(result[0]);
                coordenadas[1] = Integer.parseInt(result[1]);

                return coordenadas;
            } catch (NumberFormatException ignored) {
                System.out.println("Coordenadas invalidas, por favor tente novamente!");
            }
        }
    }

    public static void main(String[] args) {
        int[] coordenadas;
        String message;
        List<String> results = new ArrayList<>();
        Jogador p1 = criaJogador(new Cross()), p2 = criaJogador(new Circle());

        System.out.println("Vamos começar o game!!!");

        while (true) {
            int tamanhoTabuleiro = pedeTamanhoTabuleiro();
            JogoDaVelha jogo = new JogoDaVelha(tamanhoTabuleiro);

            while (true) {
                System.out.printf("Por favor %s faça sua jogada\n", p1.getName());
                do {
                    coordenadas = pegaCoordenadas();
                } while (!jogo.realizaJogada(coordenadas[0], coordenadas[1], p1.getPlayerObject()));

                System.out.println(jogo);

                if (jogo.verificaVitoria(p1.getPlayerObject())) {
                    message = String.format("Vitória de %s", p1.getName());
                    p1.incrementaPontos();
                    System.out.println(message);
                    results.add(message);
                    break;
                }

                if (jogo.verificaEmpate()) {
                    message = "Aconteceu um empate!!!";
                    System.out.println(message);
                    results.add(message);
                    break;
                }

                System.out.printf("Por favor %s faça sua jogada\n", p2.getName());
                do {
                    coordenadas = pegaCoordenadas();
                } while (!jogo.realizaJogada(coordenadas[0], coordenadas[1], p2.getPlayerObject()));

                System.out.println(jogo);

                if (jogo.verificaVitoria(p2.getPlayerObject())) {
                    message = String.format("Vitória de %s", p2.getName());
                    p2.incrementaPontos();
                    System.out.println(message);
                    results.add(message);
                    break;
                }

                if (jogo.verificaEmpate()) {
                    message = "Aconteceu um empate!!!";
                    System.out.println(message);
                    results.add(message);
                    break;
                }
            }

            while (true) {
                System.out.println("Jogadores desejam jogar novamente[S/N]");
                String response = s.nextLine();

                switch (response.trim().toUpperCase()) {
                    case "S" -> System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIniciando novo jogo!!");
                    case "N" -> {
                        System.out.println("Obrigado por jogar, voltem sempre!!");
                        try {
                            File f = new File("./tic-tac-toe/src/resultado.txt");
                            FileWriter fw = new FileWriter(f);
                            PrintWriter pw = new PrintWriter(fw);

                            pw.print(
                                """
                                #####################################################
                                #                HISTORICO DE PARTIDAS              #
                                #####################################################
                                """
                            );

                            for (int i = 0; i < results.size(); i++) {
                                pw.println(String.format("[PARTIDA %d] %s", i + 1, results.get(i)));
                            }

                            if (p1.getPoints() == p2.getPoints()) {
                                pw.println(
                                    """
                                    #####################################################
                                    #                       EMPATE                      #
                                    #####################################################
                                                      Parabens jogadores!!
                                    """
                                );
                            } else {
                                Jogador winner = p1.getPoints() > p2.getPoints() ? p1 : p2;
                                String banner = String.format(
                                    """
                                    #####################################################
                                    #%28s
                                    #####################################################
                                            %s venceu a partida com %s
                                    """,
                                    "PARABÉNS " + winner.getName().toUpperCase(),
                                    winner.getName(),
                                    String.format(winner.getPoints() > 1 ? "%d pontos" : "%d ponto", winner.getPoints())
                                );
                                pw.print(banner);
                            }

                            pw.close();

                        } catch (IOException e) {
                            System.out.println(e.getLocalizedMessage());
                            throw new RuntimeException(e);
                        }
                        return;
                    }
                    default -> {
                        System.out.println("Input invalido, tente novamente!");
                        continue;
                    }
                }

                break;
            }
        }
    }
}