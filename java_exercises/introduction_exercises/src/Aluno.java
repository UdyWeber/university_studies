public class Aluno {
    private String nome, matricula;
    private double notaGrauA, notaGrauB;

    public Aluno(String nome, String matricula, double notaGrauA, double notaGrauB) {
        this.nome = nome;
        this.matricula = matricula;
        this.notaGrauA = notaGrauA;
        this.notaGrauB = notaGrauB;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public double getNotaGrauA() {
        return this.notaGrauA;
    }

    public double getNotaGrauB() {
        return this.notaGrauB;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public void setMatricula(String newMatricula) {
        this.matricula = newMatricula;
    }

    public void setNotaGrauA(double newNotaGrauA) {
        this.notaGrauA = newNotaGrauA;
    }

    public void setNotaGrauB(double newNotaGrauB) {
        this.notaGrauB = newNotaGrauB;
    }

    public double calculaMediaFinal() {
        return (this.notaGrauA * 0.33) + (notaGrauB * 0.67);
    }

    public void  imprimeInfo() {
        System.out.printf(
            """
            =============== %s ===============
            Matricula: %s
            Nota Grau A: %.2f
            Nota Grau B: %.2f
            
            Média Final: %.2f
            %s\n
            """,
            this.nome,
            this.matricula,
            this.notaGrauA,
            this.notaGrauB,
            this.calculaMediaFinal(),
            "=".repeat(this.nome.length() + 2 + 30)
        );
    }
}