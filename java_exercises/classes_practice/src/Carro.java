public class Carro {
    private String cor, marca, nome;
    private Placa placa;

    public Carro(String cor, String marca, String nome, Placa placa) {
        this.cor = cor;
        this.marca = marca;
        this.nome = nome;
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public Placa getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public String toString() {
        return String.format(
            """
            ======================================
            * Carro: %s - %s
            * Cor: %s
            %s
            """, nome, marca, cor, placa
        );
    }
}
