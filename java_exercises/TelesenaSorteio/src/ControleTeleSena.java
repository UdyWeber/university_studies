import java.util.Arrays;

public class ControleTeleSena {
    private Pessoa[] pessoas;
    private Pessoa[] vencedores;
    private int[] numerosSorteados;
    private int teleSenasVendidas;
    private final int TOTAL_TELE_SENAS = 300;

    public ControleTeleSena(Pessoa[] pessoas) {
        this.pessoas = pessoas;

        // Igualando os valores, pois não sabemos quantos possiveis vencedores teremos.
        this.vencedores = new Pessoa[pessoas.length];

        // Comprando Tele Senas para todas as pessoas
        compraTeleSenas();
    }

    /** Função auxiliar para gerar um número aleatorio e evitar repetição de código **/
    private int geraNumero(int range) {
        return (int)(Math.random() * range + 1);
    }

    /** Função auxiliar para sortear números num Array, para que os números não venham duplicados **/
    private void sorteiaNums(int[] conjunto) {

        // Faz um loop nas posições do conjunto
        for (int i = 0; i < conjunto.length;) {

            // Sorteia um número entre 1 e 60 e setta inicialmente a sua existencia para falso
            int val = geraNumero(60);
            boolean exists = false;

            // Varre todos os valores do conjunto e verifica se o valor existe no conjunto
            for (int j = 0; j < conjunto.length; j++) {
                if (val == conjunto[j]) {
                    // Caso o valor exista no conjunto devemos parar a execução,
                    // e dizer que o valor existe no dado conjunto

                    exists = true;
                    break;
                }
            }

            // Apenas se o valor não existir no conjunto devemos adicionar e continuar andando para frente no conjunto
            // Caso contrario o ciclo se reinicia.
            if (!exists) {
                conjunto[i] = val;
                i++;
            }
        }
    }

    /** Função auxiliar para gerar conjuntos base para os conjuntos de uma Tele Sena**/
    private int[] criaConjuntoBase() {
        int[] conjunto = new int[25];
        sorteiaNums(conjunto);

        return conjunto;
    }

    /** Função auxiliar que cria as tele senas **/
    private TeleSena generateTeleSena() {
        return new TeleSena(criaConjuntoBase(), criaConjuntoBase());
    }

    /** Função auxiliar que compra as Tele Senas para cada pessoa participando do sorteio **/
    private void compraTeleSenas() {
        TeleSena[] teleSenaArray;

        // Para cada pessoa do sorteio, temos que sortear quantas Tele Senas a pessoa vai comprar
        // e adicionar uma nova Tele Sena inicializada no array de Tele Senas da pessoa
        for (Pessoa p: pessoas) {
            // Sorteia quantas Tele Senas uma pessoa vai comprar
            int qtdTeleSena = geraNumero(15);
            // Inicializa um Array de Tele Senas com a quantidade esperada
            teleSenaArray = new TeleSena[qtdTeleSena];

            for (int i = 0; i < qtdTeleSena; i++) {
                // Antes de comprar temos que verificar se ainda há Tele Senas disponiveis para venda
                if ((TOTAL_TELE_SENAS - this.teleSenasVendidas) < 0) {
                    return;
                }

                // Gera a Tele Sena e incrementa a quantidade de vendidas
                teleSenaArray[i] = generateTeleSena();
                this.teleSenasVendidas++;
            }

            // Seta o Array de Tele Senas da pessoa
            p.setTeleSenas(teleSenaArray);
        }
    }

    /** Função auxiliar para formatar os números que foram sorteados numa string que fique bonita no display final **/
    private String formataNumerosSorteados() {
        // Cria-se um novo buffer para construir uma nova String
        StringBuilder numerosSorteadosFormatados = new StringBuilder();

        // Setta um valor padrão para onde devemos quebrar a linha enquanto a String estiver crescendo
        final int TAMANHO_DO_CANVAS = 58;

        // Media de chars que vão ser adicionados enquanto estivermos criando a String.
        final int CHARS_PARA_ADICIONAR = 4;

        // Em quantas partes a string deve ser quebrada para atingirmos uma formatação decente
        final int PARTES = this.numerosSorteados.length / (TAMANHO_DO_CANVAS / CHARS_PARA_ADICIONAR);

        int currentPart = 1;


        for (int i = 0; i < this.numerosSorteados.length; i ++) {

            // Se chegou perto do limite do canvas de display quebre a linha
            if (i == (TAMANHO_DO_CANVAS / PARTES) * currentPart) {
                numerosSorteadosFormatados.append("\n");
                if (currentPart <= PARTES) {
                    currentPart++;
                }
            }

            // Continue a adicionar os números com um espaço na frente
            numerosSorteadosFormatados.append(String.format(" %d", this.numerosSorteados[i]));
        }

        // Retorne a String númerica foramtada na cor verde
        return "\u001B[32m" + numerosSorteadosFormatados + "\u001B[0m";
    }

    /**
     * Função auxiliar para formatar os nomes dos vencedores em uma unica lista e deixar mais facil para saber o número
     * real de vencedores no resultado final.
     * **/
    private String[] getNomesVencedores() {
        int totalVencedores = 0;
        for (int i = 0; i < this.vencedores.length; i++) {
            if (this.vencedores[i] == null) {
                totalVencedores = i;
                break;
            };
        }

        String[] nomesVencedores = new String[totalVencedores];

        for (int i = 0; i < nomesVencedores.length; i++) {
            nomesVencedores[i] = this.vencedores[i].getNome();
        }

        return nomesVencedores;
    }

    /**
     * Mostra os resultados da Tele Sena na tela para que os jogadores saibam quem ganhou o sorteio
     * e os números que sairam para serem apurados na sua cartela
     **/
    private void printResult() {
        String[] nomesVencedores = getNomesVencedores();
        double totalValue = getTotalValue();

        System.out.printf(
            "\u001B[34m"+ """
            =============================================================
                                    %s
            =============================================================
                                  NUMEROS SORTEADOS
                                   
            %s
            \u001B[34m
            =============================================================
            Tele Senas vendidas: %d
            Vencedores: %s
            Valor por vencedor: R$%.2f
            Total Arrecadado: R$%.2f
            Lucro do Silvio Santos: R$%.2f
            =============================================================
            """,
            nomesVencedores.length == 1 ? String.format("%d VENCEDOR", nomesVencedores.length) : String.format("%d VENCEDORES", nomesVencedores.length),
            formataNumerosSorteados(),
            teleSenasVendidas,
            Arrays.toString(nomesVencedores).replaceAll("[\\[\\]]", ""),
            (totalValue * 0.80) / nomesVencedores.length,
            totalValue,
            totalValue * 0.20

        );
    }
    /** Função auxiliar para fazer o anúncio dos números que saem no sorteio em ordem **/
    private void anunciaNumero(int numero, int pos) {
        try {
            // Anuncia a posição e dorme 1 seg para fazer um suspense...
            System.out.printf("O número %dº sorteado é...%n", pos);
            Thread.sleep(1000);
            System.out.printf("Número %d má oi!%n%n", numero);

            // Propaganda do SBT para fazer dar risadinhas em tempo de execução!
            if (pos % 5 == 0) {
                System.out.println(
                    "\u001B[32m"+ """
                                                                                                                                                         \s
                                                                                                                                                          \s
                                      JJJJJJJJJJJEEEEEEEEEEEEEEEEEEEEEE     QQQQQQQQQ      UUUUUUUU     UUUUUUUUIIIIIIIIIITTTTTTTTTTTTTTTTTTTTTTTIIIIIIIIII
                                      J:::::::::JE::::::::::::::::::::E   QQ:::::::::QQ    U::::::U     U::::::UI::::::::IT:::::::::::::::::::::TI::::::::I
                                      J:::::::::JE::::::::::::::::::::E QQ:::::::::::::QQ  U::::::U     U::::::UI::::::::IT:::::::::::::::::::::TI::::::::I
                                      JJ:::::::JJEE::::::EEEEEEEEE::::EQ:::::::QQQ:::::::Q UU:::::U     U:::::UUII::::::IIT:::::TT:::::::TT:::::TII::::::II
                                        J:::::J    E:::::E       EEEEEEQ::::::O   Q::::::Q  U:::::U     U:::::U   I::::I  TTTTTT  T:::::T  TTTTTT  I::::I \s
                                        J:::::J    E:::::E             Q:::::O     Q:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                                        J:::::J    E::::::EEEEEEEEEE   Q:::::O     Q:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                                        J:::::j    E:::::::::::::::E   Q:::::O     Q:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                                        J:::::J    E:::::::::::::::E   Q:::::O     Q:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                            JJJJJJJ     J:::::J    E::::::EEEEEEEEEE   Q:::::O     Q:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                            J:::::J     J:::::J    E:::::E             Q:::::O  QQQQ:::::Q  U:::::D     D:::::U   I::::I          T:::::T          I::::I \s
                            J::::::J   J::::::J    E:::::E       EEEEEEQ::::::O Q::::::::Q  U::::::U   U::::::U   I::::I          T:::::T          I::::I \s
                            J:::::::JJJ:::::::J  EE::::::EEEEEEEE:::::EQ:::::::QQ::::::::Q  U:::::::UUU:::::::U II::::::II      TT:::::::TT      II::::::II
                             JJ:::::::::::::JJ   E::::::::::::::::::::E QQ::::::::::::::Q    UU:::::::::::::UU  I::::::::I      T:::::::::T      I::::::::I
                               JJ:::::::::JJ     E::::::::::::::::::::E   QQ:::::::::::Q       UU:::::::::UU    I::::::::I      T:::::::::T      I::::::::I
                                 JJJJJJJJJ       EEEEEEEEEEEEEEEEEEEEEE     QQQQQQQQ::::QQ       UUUUUUUUU      IIIIIIIIII      TTTTTTTTTTT      IIIIIIIIII
                                                                                    Q:::::Q                                                               \s
                                                                                     QQQQQQ                                                               \s
                                                                                                                                                          \s
                                                                                                                                                          \s
                                                                                                                  \s
                        """ + "\u001B[0m"
                );
            }

        } catch(Exception ignored){}
    }

    /** Loop principal do programa onde o sorteio é feito e os pontos são calculados **/
    public void sorteio() {
        // Previamente já sorteia todos os números para não haverem inconsistencias nem duplicatas nos números duplicados
        // Melhora a performace, pois não temos que ficar verificando enquanto ocorrem os outros loops de checkagem
        int[] totalNums = new int[60];
        sorteiaNums(totalNums);

        int numeroVencedores = 0;

        // Loop que faz o sorteio dos números pré definidos anteriormente
        for (int i = 0; i < totalNums.length; i++) {
            int numeroSortedo = totalNums[i];

            // Mensagem caso tenhamos que continuar com a procura por um vencedor após 25 números terem sido sorteados
            if (i == 25) {
                System.out.println("Parece que não houveram vencedores :C\nVamos continuar sorteando má oi!!!!!\n");
            }

            // Anuncia novo número no terminal de Output
            anunciaNumero(numeroSortedo, i + 1);

            // Loop que apura os pontos de cada pessoa no sorteio e define se ela ganhou ou não
            // baseado nos pontos apurados
            for (int p = 0; p < pessoas.length; p++) {
                Pessoa pessoa = pessoas[p];

                if (pessoa.isVencedor(numeroSortedo)) {
                    // Se for um vencedor adicione na lista de vencedores e incremente o número de vencedores
                    this.vencedores[numeroVencedores] = pessoa;
                    numeroVencedores++;
                }
            }

            // Caso os 25 números tenham sido anunciados e existe vencedores, encerre o sorteio e defina os ganhadores
            if (i >= 25 && this.vencedores[0] != null) {
                // Ajusta os números sorteados para serem apenas os que foram anunciados
                this.numerosSorteados = new int[i + 1];

                // Popula apenas os números anunciados
                for (int j = 0; j < this.numerosSorteados.length; j++) {
                    this.numerosSorteados[j] = totalNums[j];
                }

                printResult();
                return;
            }
        }
    }

    /** Retorna o total arrecadado com a venda de todas as Tele Senas **/
    private double getTotalValue() {
        return this.teleSenasVendidas * TeleSena.valor;
    }
}
