public class Principal {
    private static Carro criaCarro() {
        String marca = Teclado.leString("Digite a marca do carro: ");
        String nome = Teclado.leString("Digite o nome do carro: ");
        String cor = Teclado.leString("Qual a cor você deseja o seu carro: ");

        System.out.println("\nQuase lá!!! Agora vamos emplacar o monstro!!!\n");

        String pais = Teclado.leString("Digite a qual pais a placa será atribuida: ");
        String numero = Teclado.leString("Escolha agora o id da sua placa: ");
        Placa placa = new Placa(pais, numero);

        System.out.println("\nCarro criado com sucesso!!!\n");
        return new Carro(cor, marca, nome, placa);
    }

    public static void main(String[] args) {
        Carro carrin = criaCarro();

        System.out.println("Imprimindo as informações do carro!");
        System.out.print(carrin);

        System.out.println("\nAtualizando a placa pro timão!!\n");
        Placa placaCarro = carrin.getPlaca();
        placaCarro.setNumero("GREM100");

        System.out.println("\nMostrando a nova placa pros colorado chorão!\n");
        System.out.print(placaCarro);
    }
}