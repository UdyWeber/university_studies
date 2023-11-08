import java.util.Arrays;
import java.util.Random;

public class ControleTeleSena {
    private Pessoa[] pessoas;
    private Pessoa[] vencedores;
    private int[] numerosSorteados;
    private int teleSenasVendidas;

    public ControleTeleSena(Pessoa[] pessoas) {
        this.pessoas = pessoas;
        this.vencedores = new Pessoa[pessoas.length];
        compraTeleSenas();
    }

    private void sorteiaNums(int[] conjunto) {
        Random rand = new Random();

        for (int i = 0; i < conjunto.length;) {
            int val = rand.nextInt(1, 61);
            boolean exists = false;

            for (int j = 0; j < conjunto.length; j++) {
                if (val == conjunto[j]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                conjunto[i] = val;
                i++;
            }
        }
    }

    private int[] criaConjuntoBase() {
        int[] conjunto = new int[25];
        sorteiaNums(conjunto);

        return conjunto;
    }

    private TeleSena generateTeleSena() {
        return new TeleSena(criaConjuntoBase(), criaConjuntoBase());
    }

    private void compraTeleSenas() {
        Random rand = new Random();
        TeleSena[] teleSenaArray;

        for (Pessoa p: pessoas) {
            int qtdTeleSena = rand.nextInt(1, 16);
            teleSenaArray = new TeleSena[qtdTeleSena];

            for (int i = 0; i < qtdTeleSena; i++) {
                if ((300 - this.teleSenasVendidas) < 0) {
                    return;
                }

                teleSenaArray[i] = generateTeleSena();
                this.teleSenasVendidas++;
            }

            p.setTeleSenas(teleSenaArray);
        }
    }

    private String formataNumerosSorteados() {
        StringBuffer x = new StringBuffer();

        final int CANVAS_SIZE = 58;
        final int CHARS_TO_APPEND = 4;
        int currentPart = 1;
        int parts = this.numerosSorteados.length / (CANVAS_SIZE / CHARS_TO_APPEND);

        for (int i = 0; i < this.numerosSorteados.length; i ++) {
            if (i == (CANVAS_SIZE / parts) * currentPart) {
                x.append("\n");
                if (currentPart <= parts) {
                    currentPart++;
                };
            }

            x.append(String.format(" %d", this.numerosSorteados[i]));
        }

        return "\u001B[32m" + x + "\u001B[0m";
    }

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

    private void anunciaNumero(int numero, int pos) {
        try {
            System.out.printf("O número %dº sorteado é...%n", pos);
            Thread.sleep(1000);
            System.out.printf("Número %d má oi!%n%n", numero);

            if (pos % 5 == 0) {
                System.out.println(
                    """
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
                        """
                );
            }

        } catch(Exception ignored){}
    }

    public void sorteio() {
        int[] totalNums = new int[60];
        sorteiaNums(totalNums);

        int start = 0;
        int range = 25;
        int v = 0;

        while (true) {
            for (int i = start; i < range; i++) {
                int numeroSortedo = totalNums[i];

                anunciaNumero(numeroSortedo, i + 1);

                for (int p = 0; p < pessoas.length; p++) {
                    Pessoa pessoa = pessoas[p];

                    if (pessoa.isVencedor(numeroSortedo)) {
                        this.vencedores[v] = pessoa;
                        v++;
                    }
                }

                if (this.vencedores[0] != null) {
                    this.numerosSorteados = new int[i];

                    for (int j = 0; j < this.numerosSorteados.length; j++) {
                        this.numerosSorteados[j] = totalNums[j];
                    }

                    printResult();
                    return;
                }
            }

            System.out.println("Parece que não houveram vencedores :C\nVamos continuar sorteando má oi!!!!!\n");

            start = range;
            range = totalNums.length;
        }
    }

    private double getTotalValue() {
        return this.teleSenasVendidas * 10.0;
    }
}
