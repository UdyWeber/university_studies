public class Exercises {
    /**
     * Faça um método chamado exercicio1 que recebe um array de inteiros e imprima-o
     * ao contrário.
     **/
    public static void exercise1(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Faça um método chamado exercicio2 que recebe um array de inteiros e retorna
     * um array com as posições invertidas.
     **/
    public static int[] exercise2(int[] arr) {
        int[] inverse = new int[arr.length];

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            inverse[i] = arr[j];
        }

        return inverse;
    }

    /**
     * Faça um método chamado exercicio3 que recebe um array de inteiros e retorna
     * um novo array que contém somente os valores pares do array recebido (não esqueça que você
     * deve saber qual o tamanho do array de retorno antes de instanciar).
     **/
    public static int[] exercise3(int[] arr) {
        int arrSize = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arrSize++;
            }
        }

        int[] x = new int[arrSize];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                x[j] = arr[i];
                j++;
            }
        }

        return x;
    }

    /**
     * Faça um método chamado exercicio4 que recebe um array de String e uma String x
     * por parâmetro. Este método retorna a posição em que a String x está no array, ou -1 se a
     * String x não estiver no array.
     **/
    public static int exercise4(String[] arr, String x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(x)) {
                return 1;
            }
        }

        return -1;
    }

    /**
     * Faça um método chamado exercicio5 que recebe um array de boolean e retorna
     * um array de inteiros contendo 1 nas posições que são true e 0 nas posições que são false.
     **/
    public static int[] exercise5(boolean[] arr) {
        int[] returnArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = arr[i] ? 1 : 0;
        }

        return returnArr;
    }

    /**
     * Faça um método chamado exercicio6 que recebe dois arrays de inteiros, e retorna
     * um terceiro array com todos os elementos dos dois arrays.
     **/
    public static int[] exercise6(int[] x, int[] y) {
        int[] z = new int[x.length + y.length];

        for (int i = 0; i < x.length; i++) {
            z[i] = x[i];
            z[x.length + i] = y[i];
        }

        return z;
    }

    /**
     * Faça um método chamado exercicio7 que recebe dois arrays de inteiros, e retorna
     * um terceiro array que possui todos os elementos negativos (dos dois arrays) na primeira parte
     * e todos os elementos positivos (inclusive o zero) na segunda parte (dos dois arrays).
     **/
    public static void exercise7(int[] x, int[] y) {
        int[] z = new int[x.length + y.length];

        // TODO: Não estou pensando o suficiente pra fazer essa
    }

    /**
     * Faça um método chamado exercicio8 que recebe um array de char e imprime na
     * tela (na mesma linha) todos os elementos do array.
     **/
    public static void exercise8(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * Faça um método chamado exercicio9 que recebe um array de inteiros e retorna a
     * média de todos os elementos do array.
     **/
    public static double exercise9(int[] arr) {
        double sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }

    /**
     * Faça um método chamado exercicio10 que recebe um array de inteiros e retorna
     * a média de todos os elementos pares do array
     **/

    public static double exercise10(int[] arr) {
        double sum = 0;
        int evenNums = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
                evenNums++;
            }
        }

        return sum / evenNums;
    }

    /**
     * Faça um método chamado exercicio11 que recebe um array de inteiros e um
     * inteiro x e retorna o elemento da posição x do array.
     **/
    public static int exercise11(int[] arr, int x) {
        return arr[x];
    }

    /**
     * Faça um método chamado exercicio12 que recebe um array de double e retorna
     * true caso algum elemento seja negativo, e false caso todos sejam positivos.
     **/
    public static boolean exericse12(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Faça um método chamado exercicio13 que recebe um array de inteiros e retorna
     * o maior elemento do array.
     **/
    public static int exercise13(int[] arr) {
        int maior = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[maior] < arr[i]) {
                maior = i;
            }
        }

        return arr[maior];
    }

    /**
     * Faça um método chamado exercicio14 que recebe um array de inteiros e retorna
     * a posição do maior elemento do array.
     **/
    public static int exercise14(int[] arr) {
        int maior = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[maior] < arr[i]) {
                maior = i;
            }
        }

        return maior;
    }

    /**
     * Faça um método chamado exercicio15 que recebe um array de inteiros e retorna
     * o menor elemento do array.
     **/
    public static int exercise15(int[] arr) {
        int menor = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[menor] > arr[i]) {
                menor = i;
            }
        }

        return arr[menor];
    }

    /**
     * Faça um método chamado exercicio16 que recebe um array de inteiros e retorna
     * a posição do menor elemento do array
     **/
    public static int exercise16(int[] arr) {
        int menor = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[menor] > arr[i]) {
                menor = i;
            }
        }

        return menor;
    }

    /** Faça um método chamado exercicio17 que recebe dois arrays de inteiros e
     retorna true caso eles sejam iguais e false caso sejam diferentes. **/
    public static boolean exercise17(int[] x, int[] y) {
        if (x.length != y.length) {
            return false;
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }

        return true;
    }

    /** Faça um método chamado exercicio18 que recebe um array de char e retorna
     uma String que representa o array (por exemplo, para o array de posições ‘G’-‘R’-‘E’-‘M’-‘I’-‘S’-
     ‘T’-‘A’, o método retorna a String “GREMISTA”). **/
    public static String exercise18(char[] arr) {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            returnString.append(arr[i]);
        }

        return returnString.toString();
    }

    /**  Faça um método chamado exercicio19 que recebe um inteiro e retorna um array
     de String preenchido com valores recebidos via Teclado. **/
    public static String[] exercise19(int arrayLen) {
        String[] x = new String[arrayLen];

        for (int i = 0; i < x.length; i++) {
            x[i] = Teclado.leString("Digite a palavra: ");
        }

        return x;
    }

    /**
     Faça um método chamado exercicio20 que recebe um array de String e um inteiro x. Este método exclui (se possível)
     o elemento da posição, “tapando o buraco” que eventualmente possa ter ficado no array. Este método retorna o array
     sem o elemento da posição x.
     **/
    public static void exercise20(String[] arr, int x) {
        if (x < 0 && x >= arr.length) {
            return;
        }

        for (int i = x; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = null;
    }

    /** Faça um método chamado exercicio21 que recebe um array de double e imprime
     somente as POSIÇÕES (não valores) pares do array. **/
    public static void exercise21(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     Crie uma classe de teste, com o método main. Neste método, crie um objeto do
     tipo Exercicios e faça:

     1) Crie um array que possa ser utilizado no exercício 1
     2) Chame o método exercicio1 do objeto Exercicios criado anteriormente
     3) Repita os passos 1 e 2 para todos os exercícios desta lista

     **/
    public static void exercise22() {

    }
}