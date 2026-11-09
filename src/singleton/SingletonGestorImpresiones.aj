public aspect SingletonGestorImpresiones {
    private GestorImpresiones instancia;
    private final Object cerrojo = new Object();

    GestorImpresiones around():
        call(GestorImpresiones.new(..)) {

        synchronized (cerrojo) {
            if (instancia == null) {
                instancia = proceed();
            }

            return instancia;
        }
    }

    public static GestorImpresiones GestorImpresiones.getInstancia() {
        return new GestorImpresiones();
    }
}