public class TeleSena {
    private final double valor = 10;
    private int acertos1, acertos2;
    private int[] conjunto1, conjunto2;

    public TeleSena(int[] conjunto1, int[] conjunto2) {
        this.conjunto1 = conjunto1;
        this.conjunto2 = conjunto2;
        this.acertos1 = 0;
        this.acertos2 = 0;
    }

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

    public double getValor() {
        return valor;
    }

    public int[] getConjunto1() {
        return conjunto1;
    }

    public int[] getConjunto2() {
        return conjunto2;
    }

    public int getAcertos1() {
        return acertos1;
    }

    public void setAcertos1(int acertos1) {
        this.acertos1 = acertos1;
    }

    public int getAcertos2() {
        return acertos2;
    }

    public void setAcertos2(int acertos2) {
        this.acertos2 = acertos2;
    }
}
