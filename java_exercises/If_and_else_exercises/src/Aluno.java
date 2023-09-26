public class Aluno{
    private String nome, matricula;
    private double notaGa, notaGb;

    public Aluno(String nome, String matricula, double notaGa, double notaGb){
        this.nome = nome;
        this.matricula = matricula;
        this.notaGa = notaGa;
        this.notaGb = notaGb;
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public double getNotaGa(){
        return notaGa;
    }

    public double getNotaGb(){
        return notaGb;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(String matricula){
        this.nome = matricula;
    }

    public void setNotaGa(double notaGa){
        this.notaGa = notaGa;
    }

    public void setNotaGb(double notaGb){
        this.notaGb = notaGb;
    }

    public double calculaMediaFinal(){
        return (notaGa * 0.33) + (notaGb * 0.67);
    }

    public boolean precisaGrauC() {
        return calculaMediaFinal() < 6;
    }

    public void imprimeInfo(){
        System.out.println("Nome do aluno: "+ nome);
        System.out.println("Matrícula: "+ matricula);
        System.out.println("Nota GA: "+ notaGa);
        System.out.println("Nota GB: "+ notaGb);
        System.out.println("Média final: "+ calculaMediaFinal() + "\n");
    }
}