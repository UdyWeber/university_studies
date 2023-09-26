public class Receita {
    private String nome, modoPreparo;
    private Ingrediente ing1, ing2, ing3, ing4, ing5;
    private boolean salgada;


    public Receita(
        String nome,
        String modoPreparo,
        Ingrediente ing1,
        Ingrediente ing2,
        Ingrediente ing3,
        Ingrediente ing4,
        Ingrediente ing5,
        boolean salgada
    ) {
        this.nome = nome;
        this.modoPreparo = modoPreparo;
        this.ing1 = ing1;
        this.ing2 = ing2;
        this.ing3 = ing3;
        this.ing4 = ing4;
        this.ing5 = ing5;
        this.salgada = salgada;
    }

    public double valorVenda() {
        double totalValue =
            (ing1.getPreco() * ing1.getQuantidade())
                + (ing2.getPreco() * ing2.getQuantidade())
                + (ing3.getPreco() * ing3.getQuantidade())
                + (ing4.getPreco() * ing4.getQuantidade())
                + (ing5.getPreco() * ing5.getQuantidade());

        totalValue = totalValue + (totalValue * 0.2);
        return totalValue;
    }

    public String getNome() {
        return nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public Ingrediente getIng1() {
        return ing1;
    }

    public Ingrediente getIng2() {
        return ing2;
    }

    public Ingrediente getIng3() {
        return ing3;
    }

    public Ingrediente getIng4() {
        return ing4;
    }

    public Ingrediente getIng5() {
        return ing5;
    }

    public boolean isSalgada() {
        return salgada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public void setIng1(Ingrediente ing1) {
        this.ing1 = ing1;
    }

    public void setIng2(Ingrediente ing2) {
        this.ing2 = ing2;
    }

    public void setIng3(Ingrediente ing3) {
        this.ing3 = ing3;
    }

    public void setIng4(Ingrediente ing4) {
        this.ing4 = ing4;
    }

    public void setIng5(Ingrediente ing5) {
        this.ing5 = ing5;
    }

    public void setSalgada(boolean salgada) {
        this.salgada = salgada;
    }


    public String toString() {
        return String.format(
            """
            ----------- %s -----------
            %s
            ---------- INGREDIENTES ----------
            * %s
            * %s
            * %s
            * %s
            * %s
            ---------- INFO ADICIONAL ----------
            Classificação: %s
            Valor Prato: %.2f
            %s
            """,
            this.nome.toUpperCase(),
            this.modoPreparo,
            this.ing1,
            this.ing2,
            this.ing3,
            this.ing4,
            this.ing5,
            this.salgada ? "Salgada" : "Doce",
            this.valorVenda(),
            "-".repeat(22 + 2 + this.nome.length())
        );
    }
}
