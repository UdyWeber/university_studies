public class PrincipalChef {
    private static Ingrediente buildIngrediente() {
        String nome = Teclado.leString("Digite o nome do ingrediente: ");
        double preco = Teclado.leDouble("Digite o valor do ingrediente: ");
        int quantidade = Teclado.leInt("Digite a quantidade necessaria do ingrediente: ");

        return new Ingrediente(nome, preco, quantidade);
    }

    private static Receita buildReceita() {
        String nome = Teclado.leString("Digite o nome da receita que vamos preparar: ");
        String modoPreparo = Teclado.leString("De uma breve descrição do modo de preparo: ");

        System.out.println("\nVamos aos ingredientes!!\n");

        System.out.println("\nPrimeiro Ingrediente\n");
        Ingrediente ing1 = buildIngrediente();

        System.out.println("\nSegundo Ingrediente\n");
        Ingrediente ing2 = buildIngrediente();

        System.out.println("\nTerceiro Ingrediente\n");
        Ingrediente ing3 = buildIngrediente();

        System.out.println("\nQuarto Ingrediente\n");
        Ingrediente ing4 = buildIngrediente();

        System.out.println("\nQuinto Ingrediente\n");
        Ingrediente ing5 = buildIngrediente();

        boolean salgada = Teclado.leString("Receita é salgada [S/N]: ").equalsIgnoreCase("S");

        return new Receita(
            nome,
            modoPreparo,
            ing1,
            ing2,
            ing3,
            ing4,
            ing5,
            salgada
        );
    }

    public static void main(String[] args) {
        String nome = Teclado.leString("Digite o nome do nosso chef: ");
        int idade = Teclado.leInt("Digite a idade do nosso chef: ");

        System.out.println("\nCrie a receita salgada do chef!\n");
        Receita receitaSalgada = buildReceita();

        System.out.println("\nCrie a receita doce do chef!\n");
        Receita receitaDoce = buildReceita();

        Chef carlos = new Chef(
            nome,
            idade,
            receitaSalgada,
            receitaDoce
        );

        System.out.println(carlos);

        System.out.printf("Receita Salgada `%s`: R$%.2f \n", receitaSalgada.getNome(), receitaSalgada.valorVenda());
        System.out.printf("Receita doce `%s`: R$%.2f \n", receitaDoce.getNome(), receitaDoce.valorVenda());

        System.out.println("\nModo de preparo da receita salgada!");
        System.out.println(receitaSalgada.getModoPreparo());

        System.out.printf(
            """
            
            Atualize o valor de um dos ingredientes da receita doce
            
            =============== Ingredientes ===============
            1 - %s
            2 - %s
            3 - %s
            4 - %s
            5 - %s
            ============================================
            """,
            receitaDoce.getIng1().getNome(),
            receitaDoce.getIng2().getNome(),
            receitaDoce.getIng3().getNome(),
            receitaDoce.getIng4().getNome(),
            receitaDoce.getIng5().getNome()
        );

        String option = Teclado.leString("Digite a opção desejada");
        double newPreco = Teclado.leDouble("\nDigite o novo valor do ingrediente");

        switch (option) {
            case "1":
                receitaDoce.getIng1().setPreco(newPreco);
                break;
            case "2":
                receitaDoce.getIng2().setPreco(newPreco);
                break;
            case "3":
                receitaDoce.getIng3().setPreco(newPreco);
                break;
            case "4":
                receitaDoce.getIng4().setPreco(newPreco);
                break;
            case "5":
                receitaDoce.getIng5().setPreco(newPreco);
                break;
        }

        System.out.println("\nPreço do ingrediente atualizado com sucesso!\n");
        System.out.println(receitaDoce);
    }
}