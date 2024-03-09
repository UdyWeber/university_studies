public class JogoDaVelha {
    private final Marker[][] grid;
    private final int border;

    public JogoDaVelha(int size) {
        this.border = size;
        this.grid = new Marker[size][size];
    }

    public boolean realizaJogada(int x, int y, Marker playerObject) {
        try {
            if ((x < 0 || x >= border) || (y < 0 || y >= border)) {
                throw new ArrayIndexOutOfBoundsException();
            }

            if (this.grid[x][y] != null) {
                throw new IndexAlreadyFilledException();
            }

            this.grid[x][y] = playerObject;

            return true;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            System.out.printf("Cordenadas vão alem do permitido [MIN=0, MAX=%d]\n", border - 1);
        } catch (IndexAlreadyFilledException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean verificaVitoria(Marker playerObj) {
        int i, j, countLine, countColumn, countDiagonal = 0, countRevDiagonal = 0;

        // Check diagonals
        for (i = 0; i < border; i++) {
            Marker itemDiagonal = grid[i][i], itemRevDiagonal = grid[i][border - 1 - i];

            countDiagonal += playerObj.equals(itemDiagonal) ? 1 : 0;
            countRevDiagonal += playerObj.equals(itemRevDiagonal) ? 1: 0;

            if (countDiagonal == border && countRevDiagonal == border) {
                return true;
            }
        }

        // Check lines and columns
        for (i = 0; i < border; i++) {
            countLine = 0;
            countColumn = 0;
            for (j = 0; j < border; j++) {
                Marker itemLine = grid[i][j], itemColumn = grid[j][i];

                countLine += playerObj.equals(itemLine) ? 1 : 0;
                countColumn += playerObj.equals(itemColumn) ? 1 : 0;
            }

            if (countLine == border || countColumn == border) {
                return true;
            }
        }


        return false;
    }

    public boolean verificaEmpate() {
        int i, j, nulls = 0;

        for (i = 0; i < border; i++) {
            for (j = 0; j < border; j++) {
                if (grid[i][j] == null) {
                    nulls++;
                }
            }
        }

        return nulls == 0;
    }


    @Override
    public String toString() {
        StringBuilder tabuleiro = new StringBuilder();

        // Start composing the board
        for (int i = 0; i < border; i++) {
            StringBuilder line = new StringBuilder();

            // Draw line with formated fields
            for (int j = 0; j < border; j++) {
                Marker item = this.grid[i][j];
                String field = j == border - 1
                    ? String.format("%3s \n", item != null ? item.toString() : "")
                    : String.format("%3s |", item != null ? item.toString() : "");
                line.append(field);
            }
            tabuleiro.append(line);

            // Draw barrier between lines
            if (i != border - 1) {
                String barrier = "----|".repeat(border - 1) + "----\n";
                tabuleiro.append(barrier);
            }
        }

        return tabuleiro.toString();
    }
}

