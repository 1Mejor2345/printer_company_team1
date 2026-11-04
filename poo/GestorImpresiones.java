public final class GestorImpresiones {
    private static final GestorImpresiones INSTANCIA = new GestorImpresiones();
    private int total = 0;

    private GestorImpresiones() {}

    public static GestorImpresiones getInstancia() {
        return INSTANCIA;
    }

    public void imprimir(Impresora impresora, String documento) {
        impresora.imprimir(documento);
        total++;
    }

    public int getTotal() {
        return total;
    }
}
