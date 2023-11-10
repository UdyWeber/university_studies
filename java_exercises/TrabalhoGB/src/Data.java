import java.time.LocalDateTime;

public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data() {
        LocalDateTime now = LocalDateTime.now();
        this.dia = now.getDayOfMonth();
        this.mes = now.getMonthValue();
        this.ano = now.getYear();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        String sDay = this.dia < 10 ? "0" + this.dia : "" + this.dia;
        String sMonth = this.mes < 10 ? "0" + this.mes : "" + this.mes;

        return String.format("%s/%s/%d", sDay, sMonth, this.ano);
    }
}
