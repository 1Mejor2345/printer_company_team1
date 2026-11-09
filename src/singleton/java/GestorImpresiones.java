public final class GestorImpresiones {
    private int total = 0;

    public GestorImpresiones() {
    }

    public void imprimir(Impresora impresora, String documento) {
        impresora.imprimir(documento);
        total++;
    }

    public int getTotal() {
        return total;
    }
}