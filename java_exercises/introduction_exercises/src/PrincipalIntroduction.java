public class PrincipalIntroduction {
    public static void main(String[] args) {
        // Exercise a
        Aluno x = new Aluno("Brandamente Brasil", "1585248", 5, 9);
        Aluno y = new Aluno("Radigunda Cercená", "2254879", 8, 2);
        Aluno z = new Aluno("Vitimado José Araújo", "0085994", 7, 1);

        // Exercise b
        x.imprimeInfo();
        y.imprimeInfo();
        z.imprimeInfo();

        // Exercise c
        y.setNotaGrauA(9);

        // Exercise d
        System.out.printf("Média final de Radigunda: %.2f\n", y.calculaMediaFinal());

        // Exercise e
        System.out.println("Matrícula de Vitimado: " + z.getMatricula());

        // Exercise f
        x.setMatricula("1585228");
        System.out.println("Nova matrícula de Brandamente: " + x.getMatricula());
    }
}