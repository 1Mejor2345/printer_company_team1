public class MainAOP {
    public static void main(String[] args) {
        Impresora impresora =
                new AdaptadorImpresora(new ImpresoraAntigua());

        GestorImpresiones gestor1 =
                GestorImpresiones.getInstancia();
        GestorImpresiones gestor2 =
                GestorImpresiones.getInstancia();
        GestorImpresiones gestor3 =
                new GestorImpresiones();

        gestor1.imprimir(impresora, "Tarea de Java");
        gestor3.imprimir(impresora, "Diagrama UML");

        System.out.println("Mismo gestor: " + (gestor1 == gestor2));
        System.out.println("Constructor interceptado: "
                + (gestor1 == gestor3));
        System.out.println("Total de impresiones: "
                + gestor1.getTotal());
    }
}