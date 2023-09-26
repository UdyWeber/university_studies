public class PrincipalAluno{
    private static Aluno criaAlunoComTeclado() {
        String nome = Teclado.leString("Digite o nome do novo aluno: ");
        String matricula = Teclado.leString("Digite a matricula do novo aluno: ");
        double notaGrauA = Teclado.leDouble("Digite a nota do grau A do aluno: ");
        double notaGrauB = Teclado.leDouble("Digite a nota do grau B do aluno: ");

        return new Aluno(nome, matricula, notaGrauA, notaGrauB);
    };

    private static void ajustaNota(Aluno aluno) {
        double mediaFinal = aluno.calculaMediaFinal();

        if (mediaFinal < 6) {
            double x = (6 - (aluno.getNotaGa() * 0.33));
            double y = x / 0.67;
            aluno.setNotaGb(y);
        }
    }

    public static void main(String[] args) {

        Aluno x = new Aluno("Petrônio", "0058487", 1.6, 7.1);
        Aluno y = new Aluno("Javonilda", "1254870", 9.5, 9.3);
        Aluno z = new Aluno("Josepha", "4487512", 7.7, 2.3);

        System.out.println("Informações dos alunos:\n");
        x.imprimeInfo();
        y.imprimeInfo();
        z.imprimeInfo();

        System.out.println("Alunos que precisam do grau C\n");

        if (x.precisaGrauC())
            System.out.println(x.getNome());
        if (y.precisaGrauC())
            System.out.println(y.getNome());
        if (z.precisaGrauC())
            System.out.println(z.getNome());

        System.out.println("\n Criando alunos com teclado:\n");

        Aluno novo1 = criaAlunoComTeclado();
        Aluno novo2 = criaAlunoComTeclado();
        Aluno novo3 = criaAlunoComTeclado();

        ajustaNota(novo3);
        ajustaNota(novo1);
        ajustaNota(novo2);

        System.out.println(novo3.calculaMediaFinal());
        System.out.println(novo1.calculaMediaFinal());
        System.out.println(novo2.calculaMediaFinal());
    }
}