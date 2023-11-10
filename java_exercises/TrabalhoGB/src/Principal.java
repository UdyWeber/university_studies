import java.util.Random;

public class Principal {
    public static Data generateRandomData() {
        return new Data(
            generateRandomNumber(31),
            generateRandomNumber(12),
            generateRandomNumber(2030)
        );
    }

    public static int generateRandomNumber(int range) {
        return (int) (Math.random() * range + 1);
    }

    public static Produto criaProduto(int pos) {
        return new Produto(
            String.format("Produto %d", pos),
            String.format("Descrição do Produto %d", pos),
            new Random().nextDouble(0, 1000)
        );
    }

    public static Perecivel criarPerecivel(int pos) {
        Produto x = criaProduto(pos);
        return new Perecivel(x.getNome(), x.getDescricao(), x.getValor(), generateRandomData());
    }

    public static NaoPerecivel criarNaoPerecivel(int pos) {
        Produto x = criaProduto(pos);
        return new NaoPerecivel(x.getNome(), x.getDescricao(), x.getValor(), generateRandomData());
    }

    public static void main(String[] args) {
        int tamanhoProdutos = generateRandomNumber(20);

        Produto[] x = new Produto[tamanhoProdutos];

        System.out.printf(
                """
                =================================================================
                                       INSERINDO %d ITEMS
                =================================================================
                
                """, tamanhoProdutos
        );

        Produto maisCaro = null;

        for (int i = 0; i < x.length; i++) {
            int num = generateRandomNumber(100);
            int pos = i + 1;

            Produto p = switch (num % 2) {
                case 0 -> criarPerecivel(pos);
                default -> criarNaoPerecivel(pos);
            };

             if (maisCaro == null) {
                maisCaro = p;
             } else if (p.getValor() > maisCaro.getValor()) {
                maisCaro = p;
             }

            System.out.printf("Adicionando produto <<%s>> na posição: %d%n", p.getClass().getName().toUpperCase(), pos);

            x[i] = p;
        }

        System.out.printf(
            """
            
            =================================================================
                                    PRODUTO MAIS CARO
            =================================================================
            %s
            
            """,maisCaro
        );

        System.out.println(
            """
            =================================================================
             PRINTANDO DATA DE FABRIACAÇÃO DOS PRODUTOS FEITOS ANTES DE 2023
            =================================================================
            """
        );

        for (int i = 0; i < x.length; i++) {
            if (x[i] instanceof Perecivel) {
                continue;
            }

            Data d = ((NaoPerecivel)x[i]).getDataFabricacao();

            if (d.getAno() < 2023) {
                System.out.printf("O produto não perecivel na posição %d foi produzido em %s%n", i + 1, d);
            }
        }

        Data nowMyDate = new Data();

        System.out.printf(
            """
            
            =================================================================
               PRINTANDO PRODUTOS PERECIVEIS VENCIDOS (HOJE = %s)
            =================================================================
            
            """, nowMyDate
        );

        for (int i = 0; i < x.length; i++) {
            if (x[i] instanceof NaoPerecivel) {
                continue;
            }

            Perecivel p = (Perecivel) x[i];

            if (p.isVencido(nowMyDate)) {
                System.out.println(x[i]);
            }
        }

    }
}