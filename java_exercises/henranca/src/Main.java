// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Claudinho", 9);
        while (true) {
            switch (Teclado.leInt("Digite 1 para programador e 2 para Aluno!!!")) {
                case 1 -> p = new Programador(p.getNome(), p.getIdade(), "Scala");
                case 2 -> p = new Aluno(p.getNome(), p.getIdade(), 420.69);
                default -> {
                    System.out.println("Opção invalida!!!!");
                    continue;
                }
            }

            break;
        }

        if (p instanceof Programador) {
            System.out.printf("A linguagem preferida de %s é %s", p.getNome(), ((Programador) p).getLinguaguem());
        } else {
            System.out.printf("A nota da escola de %s é %.2f", p.getNome(), ((Aluno) p).getNota());
        }

    }
}
