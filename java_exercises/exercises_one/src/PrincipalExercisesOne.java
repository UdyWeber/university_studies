public class Principal {
    public static void main(String[] args) {
        Livro blankBook = new Livro();
        Livro strawberryFields = new Livro(
            "Campos de Morango",
            "Luisa Sonza",
            2023,
            10,
            420.69
        );
        System.out.println(strawberryFields);
        System.out.println(blankBook);

        Cliente blankClient = new Cliente();
        Cliente jawClient = new Cliente(
            "umemail@email.com.br",
            "Jaw",
            "Masculino",
            "minhasenha",
            20,
            strawberryFields
        );

        blankClient.imprimeInformacoes();
        jawClient.imprimeInformacoes();

        System.out.println(blankClient);
        System.out.println(jawClient);

        System.out.println("Atividade da facul abaixo \n");

        Livro sexo2 = new Livro("Sexo 2 para iniciantes", "CEO do Sexo", 1804, 25, 69.420);
        Livro nft = new Livro("Teoria para starters no mercado NFT", "CEO do NFT", 1692, 55, 420.69);

        // Clientes
        Cliente giorgino = new Cliente("giorgis.hotmail.com", "123568", "Giorgino");
        giorgino.setLivroCliente(sexo2);

        Cliente claudetilde = new Cliente("cloudis.hotmail.com", "12351238", "Claudetilde");
        claudetilde.setLivroCliente(nft);

        Cliente saxofonildo = new Cliente("saxofonildox.hotmail.com", "1319213", "Saxofonildo");
        saxofonildo.setLivroCliente(sexo2);

        Livro claudetildeBook = claudetilde.getLivroCliente();
        System.out.printf(
            "O cliente %s está com o livro %s, e o preço por página deste livro é R$%.2f\n",
            claudetilde.getNome(),
            claudetildeBook.getTitulo(),
            claudetildeBook.calcularPrecoPorPagina()
        );

        Livro giorginoBook = giorgino.getLivroCliente();
        System.out.printf(
            "O cliente %s está com o livro %s, e o preço por página deste livro é R$%.2f\n",
            giorgino.getNome(),
            giorginoBook.getTitulo(),
            giorginoBook.calcularPrecoPorPagina()
        );

        Livro saxofonildoBook = saxofonildo.getLivroCliente();
        System.out.printf(
            "O cliente %s está com o livro %s, e o preço por página deste livro é R$%.2f\n",
            saxofonildo.getNome(),
            saxofonildoBook.getTitulo(),
            saxofonildoBook.calcularPrecoPorPagina()
        );

        claudetilde.imprimeInformacoes();
        giorgino.imprimeInformacoes();
        saxofonildo.imprimeInformacoes();
    }
}