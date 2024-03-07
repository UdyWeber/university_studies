import java.util.Scanner;

public class Game {
    private final Marker[][] grid;
    private String player1, player2;
    private static final int BORDER = 3;
    private static final Scanner s = new Scanner(System.in);

    public Game() {
        this.grid = new Marker[BORDER][BORDER];
        createPlayers();
    }

    private void createPlayers() {
        while (true) {
            System.out.println("Bem vindos jogadores, por favor jogador 1, escreva circulos ou cruzes para selecionar o seu lado: ");
            player1 = s.nextLine().trim().toUpperCase();
            if (player1.equalsIgnoreCase("CIRCULOS") || player1.equalsIgnoreCase("CRUZES")) {
                break;
            }
            System.out.println("Opção invalida, tente novamente");
        }

        player2 = player1.equalsIgnoreCase("CIRCULOS") ? "CRUZES" : "CIRCULOS";
    }

    public void play() {
        System.out.println("Vamos começar o game!!!");

        while (true) {
            System.out.println("Por favor jogador 1 faça sua jogada");
            makeMove(player1);
            drawGrid();

            if (checkWin(player1)) {
                System.out.printf("Vitória de %s\n", player1.toLowerCase());
                break;
            }

            System.out.println("Por favor jogador 2 faça sua jogada");
            makeMove(player2);
            drawGrid();

            if (checkWin(player2)) {
                System.out.printf("Vitória de %s\n", player2.toLowerCase());
                break;
            }
        }
    }

    private void makeMove(String player) {
        int x, y;

        while (true) {
            System.out.print("Digite as cordenadas entre da sua jogada separado com '-' [EX: 1-2 arg1=linha agr2=coluna]: ");
            String[] result = s.nextLine().trim().split("-");

            try {
                x = Integer.parseInt(result[0]);
                y = Integer.parseInt(result[1]);

                if ((x < 0 || x >= BORDER) || (y < 0 || y >= BORDER)) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                if (this.grid[x][y] != null) {
                    throw new IndexAlreadyFilledException();
                }

                Marker insert = player.equals("CIRCULOS") ? new Circle() : new Cross();
                this.grid[x][y] = insert;

                break;
            } catch (NumberFormatException ignored) {
                System.out.println("Cordenadas ilegais, por favor insira novamente");
            } catch (ArrayIndexOutOfBoundsException ignored) {
                System.out.println("Cordenadas vão alem do permitido [MIN=0, MAX=2]");
            } catch (IndexAlreadyFilledException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void drawGrid() {
        String i1, i2, i3;

        for (int i = 0; i < BORDER; i++) {
            i1 = this.grid[i][0] != null ? this.grid[i][0].toString() : "";
            i2 = this.grid[i][1] != null ? this.grid[i][1].toString() : "";
            i3 = this.grid[i][2] != null ? this.grid[i][2].toString() : "";

            System.out.printf("%3s |%3s |%3s\n", i1, i2, i3);

            if (i != BORDER - 1) {
                char[] barrier = "-".repeat(14).toCharArray();
                barrier[4] = barrier[9] = '|';
                System.out.println(barrier);
            }
        }
    }

    private boolean checkWin(String player) {
        int i, j, countLine, countColumn, countDiagonal = 0, countRevDiagonal = 0;

        Marker playerObj = player.equalsIgnoreCase("CIRCULOS") ? new Circle() : new Cross();

        // Check diagonals
        for (i = 0; i < BORDER; i++) {
            Marker itemDiagonal = grid[i][i], itemRevDiagonal = grid[i][BORDER - 1 - i];

            countDiagonal += playerObj.equals(itemDiagonal) ? 1 : 0;
            countRevDiagonal += playerObj.equals(itemRevDiagonal) ? 1: 0;

            if (countDiagonal == BORDER || countRevDiagonal == BORDER) {
                return true;
            }
        }

        // Check lines and columns to see if shit goes bruuuh
        for (i = 0; i < BORDER; i++) {
            countLine = 0;
            countColumn = 0;
            for (j = 0; j < BORDER; j++) {
                Marker itemLine = grid[i][j], itemColumn = grid[j][i];

                countLine += playerObj.equals(itemLine) ? 1 : 0;
                countColumn += playerObj.equals(itemColumn) ? 1 : 0;
            }

            if (countLine == BORDER || countColumn == BORDER) {
                return true;
            }
        }


        return false;
    }
}

