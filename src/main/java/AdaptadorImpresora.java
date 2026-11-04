public class AdaptadorImpresora implements Impresora {
    private final ImpresoraAntigua antigua;

    public AdaptadorImpresora(ImpresoraAntigua antigua) {
        this.antigua = antigua;
    }

    @Override
    public void imprimir(String documento) {
        antigua.imprimirTexto(documento);
    }
}
