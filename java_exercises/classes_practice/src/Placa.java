public class Placa {
    private String pais, numero;

    public Placa(String pais, String numero) {
        this.numero = numero;
        this.pais = pais;
    }

    public String getNumero() {
        return numero;
    }

    public String getPais() {
        return pais;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String toString(){
        return String.format(
            """
            ======================================
            * Número: %s
            * Pais: %s
            ======================================
            """, numero, pais
        );
    }
}
