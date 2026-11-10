public class MainAOP {
    public static void main(String[] args) {
        Impresora impresora = new ImpresoraAntigua();
        GestorImpresiones gestor1 = GestorImpresiones.getInstancia();
        GestorImpresiones gestor2 = GestorImpresiones.getInstancia();

        gestor1.imprimir(impresora, "Tarea de Java");
        gestor2.imprimir(impresora, "Diagrama UML");

        System.out.println("Mismo gestor: " + (gestor1 == gestor2));
        System.out.println("Total de impresiones: " + gestor1.getTotal());
        if (gestor1 != gestor2 || gestor1.getTotal() != 2) {
            throw new AssertionError("Referencias o contador incorrectos");
        }
    }
}
