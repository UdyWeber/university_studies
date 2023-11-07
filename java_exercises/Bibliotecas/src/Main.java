import java.util.Random;

public class Main {
    private static Livro criaLivro() {
        return new Livro(
            generateRandomString(),
            generateRandomString(),
            Math.random(),
            sorteiaNum(2030)
        );
    }

    private static Antigo criaLivroAntigo() {
        Livro x = criaLivro();
        return new Antigo(x.titulo, x.autor, x.preco, x.anoDeCriacao, sorteiaNum(10));
    }

    private static Novo criaLivroNovo() {
        Livro x = criaLivro();
        return new Novo(x.titulo, x.autor, x.preco, x.anoDeCriacao, Math.random());
    }

    private static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = sorteiaNum(30);
        Random random = new Random();

        String generatedString = random
                .ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    private static int sorteiaNum(int range) {
        return (int) (Math.random() * range + 1);
    }

    public static void main(String[] args) {
        int size = sorteiaNum(200);
        Biblioteca b = new Biblioteca(size);

        int quant = sorteiaNum(300);

        for (int i = 0; i < quant; i++) {
            boolean inserido = switch (sorteiaNum(2)) {
                case 1 -> b.insereLivro(criaLivroNovo());
                case 2 -> b.insereLivro(criaLivroAntigo());
                default -> false;
            };

            if (inserido) {
                System.out.println("Livro inserido com sucesso!");
            } else {
                System.out.println("Não foi possivel inserir o livro!");
            }
        }


        String titulo = Teclado.leString("Digite o nome do livro que deseja buscar: ");
        Livro x = b.procuraLivroPorTitulo(titulo);

        if(x == null) {
            System.out.println("ERRO: LIVRO NÃO ENCONTRADO!!!");
        } else {
            System.out.println(x);
        }

        titulo = Teclado.leString("Digite o nome do livro que deseja buscar desconto: ");
        double y = b.verificaDescontro(titulo);

        if(y == -1) {
            System.out.println("ERRO: LIVRO NÃO ENCONTRADO!!!");
        } else {
            System.out.printf("Valor do desconto do livro: R$%.2f%n", y);
        }

        b.imprimeEdicoes();
        b.imprimeLivroPorAno();

        double media = b.calculaMediaPreco();
        System.out.printf("Valor medio da biblioteca avaliado em R$%.2f%n", media);

        System.out.println("Livro com maior titulo abaixo");
        Livro maior = b.livroComMaiorTitulo();

        System.out.println(maior);

    }
}