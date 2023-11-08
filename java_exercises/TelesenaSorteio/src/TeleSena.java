public class TeleSena {
    // Esse campo é final pois o valor da Tele Sena nunca vai mudar
    // E é static para ser referenciado em qualquer lugar do código como uma constante da classe TeleSena
    public static final double valor = 10;
    private int acertos1, acertos2;
    private int[] conjunto1, conjunto2;

    public TeleSena(int[] conjunto1, int[] conjunto2) {
        this.conjunto1 = conjunto1;
        this.conjunto2 = conjunto2;
        this.acertos1 = 0;
        this.acertos2 = 0;
    }

    /** Faz a apuração da quantidade de pontos que cada um dos conjuntos realizou de acordo com o sorteio **/
    public void atualizaAcertos(int numeroSortedo) {
        for (int num = 0; num < this.conjunto1.length; num++) {
            if (this.conjunto1[num] == numeroSortedo) {
                this.acertos1++;
                break;
            }
        }

        for (int num = 0; num < this.conjunto2.length; num++) {
            if (this.conjunto2[num] == numeroSortedo) {
                this.acertos2++;
                break;
            }
        }
    }

    /** Retorna se algum de seus conjuntos marcou 25 pontos, caso seja verdadeiro, a Tele Sena é uma das ganhadoras **/
    public boolean isPremiada() {
        return this.acertos1 == 25 || this.acertos2 == 25;
    }
}
