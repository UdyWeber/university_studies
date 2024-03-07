class IndexAlreadyFilledException extends Exception {
    public IndexAlreadyFilledException() {
        super("Já foi colocado um marcador nessas coordenadas, por favor jogue novamente!");
    }
}