import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labirinto {
    private Peca atual;

    public Labirinto() {}

    public Peca[][] carregaLabirinto(String filename) {
        Peca[][] maze;
        try {
            int i = 0, j;

            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            int lines = Integer.parseInt(myReader.nextLine());
            int columns = Integer.parseInt(myReader.nextLine());

            maze = new Peca[lines][columns];

            while (myReader.hasNextLine()) {
                char[] data = myReader.nextLine().toCharArray();

                j = 0;
                // mapeia cada peça para seu respetivo caractere
                for (char c : data) {
                    maze[i][j] = createPeca(c, i, j);
                    j++;
                }
                // Preenche as linhas q tiverem faltando com caminho, por que o readline come os espaços
                for (;j < columns; j++) {
                    maze[i][j] = createPeca(' ', i, j);
                }

                i++;
            }
            myReader.close();

            this.atual = maze[0][0];
            return maze;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }

    // Cria cada peça do labirinto, e deixa mais facil para fazer as comparações.
    private Peca createPeca(char simbol, int i, int j) {
        return switch (simbol) {
            case 'X' -> new Parede(i, j);
            case 'D' -> new Vitoria(i, j);
            case ' ' -> new Caminho(i, j);
            default -> throw new IllegalStateException("Unexpected value: " + simbol);
        };
    }

    // Checa se a nova posição está dentro dos limites do labirinto
    private boolean checkValidPosition(int newI, int newJ, int maxLine, int maxColumn) {
        return (newI >= 0 && newI < maxLine) && (newJ >= 0 && newJ < maxColumn);
    }

    public boolean labirinto(Peca[][] lab) {
        // Se tiver chegado na vitoria ele vai retroceder toda recursão e vai retornar True,
        // caso contrario ele vai retroceder e nunca vai alterar o valor do completed oq quer
        // dizer que ele não achou o fim do labirinto
        if (this.atual instanceof Vitoria) {
            return true;
        }

        final int maxLine = lab.length, maxColumn = lab[0].length;
        boolean completed = false;
        Peca tempCur = this.atual;

        if (tempCur instanceof Caminho && !tempCur.isVisited()) {
            // Diz que já passamos pelo caminho atual
            tempCur.setVisited(true);

            // Checa se o caminho de cima é valido
            if (!completed && checkValidPosition(tempCur.getI()-1, tempCur.getJ(), maxLine, maxColumn)) {
                this.atual = lab[tempCur.getI() - 1][tempCur.getJ()];
                completed = labirinto(lab);
            }

            // Checa se o caminho da esquerda é valido
            if (!completed && checkValidPosition(tempCur.getI(), tempCur.getJ()+1, maxLine, maxColumn)) {
                this.atual = lab[tempCur.getI()][tempCur.getJ() + 1];
                completed = labirinto(lab);
            }

            // Checa se o caminho de baixo é valido
            if (!completed && checkValidPosition(tempCur.getI()+1, tempCur.getJ(), maxLine, maxColumn)) {
                this.atual = lab[tempCur.getI() + 1][tempCur.getJ()];
                completed = labirinto(lab);
            }

            // Checa se o caminho da esquerda é valido
            if (!completed && checkValidPosition(tempCur.getI(), tempCur.getJ()-1, maxLine, maxColumn)) {
                this.atual = lab[tempCur.getI()][tempCur.getJ() - 1];
                completed = labirinto(lab);
            }
        }

        return completed;
    }

}

