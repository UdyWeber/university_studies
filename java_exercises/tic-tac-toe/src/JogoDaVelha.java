import java.util.Scanner;

public class JogoDaVelha {
    private final Marker[][] grid;
    private final int BORDER;
    private String player1, player2;
    private static final Scanner s = new Scanner(System.in);

    public JogoDaVelha(int size) {
        this.BORDER = size;
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
            System.out.println(this);

            if (checkWin(player1)) {
                System.out.printf("Vitória de %s\n", player1.toLowerCase());
                break;
            }

            System.out.println("Por favor jogador 2 faça sua jogada");
            makeMove(player2);
            System.out.println(this);

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
                System.out.printf("Cordenadas vão alem do permitido [MIN=0, MAX=%d]\n", BORDER - 1);
            } catch (IndexAlreadyFilledException e) {
                System.out.println(e.getMessage());
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

            if (countDiagonal == BORDER && countRevDiagonal == BORDER) {
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

    @Override
    public String toString() {
        StringBuilder tabuleiro = new StringBuilder();

        // Start composing the board
        for (int i = 0; i < BORDER; i++) {
            StringBuilder line = new StringBuilder();

            // Draw line with formated fields
            for (int j = 0; j < BORDER; j++) {
                Marker item = this.grid[i][j];
                String field = j == BORDER - 1
                    ? String.format("%3s \n", item != null ? item.toString() : "")
                    : String.format("%3s |", item != null ? item.toString() : "");
                line.append(field);
            }
            tabuleiro.append(line);

            // Draw barrier between lines
            if (i != BORDER - 1) {
                String barrier = "----|".repeat(BORDER - 1) + "----\n";
                tabuleiro.append(barrier);
            }
        }

        return tabuleiro.toString();
    }
}

