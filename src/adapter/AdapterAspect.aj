public aspect AdapterAspect {
    declare parents: ImpresoraAntigua implements Impresora;

    public void ImpresoraAntigua.imprimir(String documento) {
        imprimirTexto(documento);
    }
}
