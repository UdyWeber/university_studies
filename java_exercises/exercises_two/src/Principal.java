

public class Principal {
    private static void printProdutosVencidos(Mercado m, Data dateToCheck) {
        Prateleira x = m.getPrat1();
        Prateleira z = m.getPrat2();

        if (x.getProd1() != null && x.getProd1().verificaProdutoVencido(dateToCheck)) {
            System.out.println(x.getProd1());
        }

        if (x.getProd2() != null && x.getProd2().verificaProdutoVencido(dateToCheck)) {
            System.out.println(x.getProd2());
        }

        if (x.getProd3() != null && x.getProd3().verificaProdutoVencido(dateToCheck)) {
            System.out.println(x.getProd3());
        }

        if (z.getProd1() != null && z.getProd1().verificaProdutoVencido(dateToCheck)) {
            System.out.println(z.getProd1());
        }

        if (z.getProd2() != null && z.getProd2().verificaProdutoVencido(dateToCheck)) {
            System.out.println(z.getProd2());
        }

        if (z.getProd3() != null && z.getProd3().verificaProdutoVencido(dateToCheck)) {
            System.out.println(z.getProd3());
        }


    }
    public static void main(String[] args) {
        Produto amaciante = new Produto(
            "Amaciante",
            Teclado.leDouble("Digite o valor do amaciante: "),
            new Data(10, 4, 2014)
        );

        Produto cremeDental = new Produto(
            "Creme dental",
            Teclado.leDouble("Digite o valor do creme dental: "),
            new Data(5, 5, 2015)
        );

        Produto leiteCondensado = new Produto(
            "Leite condensado",
            Teclado.leDouble("Digite o valor do leite condensado: "),
            new Data(4, 12, 2012)
        );

        Prateleira prat1 = new Prateleira(amaciante, cremeDental, leiteCondensado);

        Prateleira prat2 = new Prateleira();

        Produto cortina = new Produto(
            "Cortina",
            167.98,
            new Data(13, 10, 2025)
        );

        prat2.setProd1(cortina);

        Mercado mercadinDoSeuZe = new Mercado(prat1, prat2);

        System.out.println("\nImprimindo produtos vencidos!\n");
        printProdutosVencidos(mercadinDoSeuZe, new Data(10, 10, 2014));

        Produto prat1ProdutoMaisCaro = mercadinDoSeuZe.getPrat1().produtoMaisCaro();
        Produto prat2ProdutoMaisCaro = mercadinDoSeuZe.getPrat2().produtoMaisCaro();

        System.out.println("Imprimindo o produto mais caro do mercado!\n");

        if (prat1ProdutoMaisCaro.getPreco() > prat2ProdutoMaisCaro.getPreco()) {
            System.out.println(prat1ProdutoMaisCaro);
        } else {
            System.out.println(prat2ProdutoMaisCaro);
        }

        System.out.printf("Media de preços do mercado é: R$%.2f", mercadinDoSeuZe.mediaValorProdutos());
    }
}