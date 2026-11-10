# Sistema de impresiones - Team 01

Tarea 01 de Diseño de Software (ESPOL): patrones de diseño **Adapter** y **Singleton**.

## Sección A - Programación orientada a objetos (implementada)

Ejemplo: una aplicación usa el método `imprimir()`, mientras que una impresora antigua solo ofrece `imprimirTexto()`. El adaptador permite reutilizarla sin modificar la clase antigua. Un gestor Singleton cuenta las impresiones desde un único objeto.

| Archivo | Función |
| --- | --- |
| `src/main/java/Impresora.java` | Interfaz que define el método moderno. |
| `src/main/java/ImpresoraAntigua.java` | Clase con el método heredado. |
| `src/main/java/AdaptadorImpresora.java` | Implementa `Impresora` y delega en la clase antigua. |
| `src/main/java/GestorImpresiones.java` | Singleton que centraliza el contador. |
| `src/main/java/Main.java` | Demuestra ambos patrones. |
| `uml/*.drawio` y `uml/*.svg` | Diagramas de clases UML editables en diagrams.net y sus imágenes vectoriales. |

## Sección C - Singleton orientado a aspectos (implementado)

El aspecto intercepta las llamadas al constructor de `GestorImpresiones` y reutiliza la primera instancia. `MainAOP` comprueba que las referencias y el contador sean compartidos. Requiere compilar con AspectJ.

| Archivo | Función |
| --- | --- |
| `src/singleton/java/GestorImpresiones.java` | Clase del gestor, sin lógica Singleton. |
| `src/singleton/SingletonGestorImpresiones.aj` | Controla la instancia única e introduce `getInstancia()`. |
| `src/singleton/java/MainAOP.java` | Prueba los accesos y compara las referencias. |

### Ejecutar la sección A con Maven (JDK 17 o superior)

1. Clonar el repositorio y abrirlo en Visual Studio Code.
2. Abrir la terminal integrada.
3. Ejecutar:

```bash
mvn clean package
java -jar target/printer-company-1.0.0.jar
```

Salida esperada:

```text
Impresora antigua: Tarea de Java
Impresora antigua: Diagrama UML
Mismo gestor: true
Total de impresiones: 2
```

El archivo `pom.xml` configura compilación con `release 17` y un JAR ejecutable cuyo punto de entrada es `Main`. Maven coloca los archivos generados en `target/`, excluido del control de versiones. No hay dependencias de aplicación ni pruebas automatizadas: `mvn package` verifica la compilación y el empaquetado; la ejecución del JAR es la comprobación funcional de la salida indicada. Las capturas del informe deben proceder del editor y de la terminal integrada reales de VS Code.

## Sección B - Adapter orientado a aspectos

`src/adapter/AdapterAspect.aj` introduce `Impresora` y el método `imprimir(String)` en `ImpresoraAntigua`. El método añadido delega en `imprimirTexto(String)`. B reutiliza el gestor Singleton OO de A y conserva sus clases originales. Las variantes B y C se compilan por separado.

`src/adapter/java/MainAOP.java` asigna directamente `new ImpresoraAntigua()` a una referencia `Impresora`, imprime dos documentos y comprueba las referencias y el contador. El diagrama editable está en `uml/adapter-aop.dot`.

### Compilar y ejecutar B (PowerShell)

Instalar JDK 17 o superior. Descargar AspectJ 1.9.25 y guardar ambos archivos en una carpeta como `C:/aspectj/lib`, con estos nombres:

- [aspectjtools.jar](https://repo.maven.apache.org/maven2/org/aspectj/aspectjtools/1.9.25/aspectjtools-1.9.25.jar)
- [aspectjrt.jar](https://repo.maven.apache.org/maven2/org/aspectj/aspectjrt/1.9.25/aspectjrt-1.9.25.jar)

Desde la raíz del repositorio:

```powershell
./scripts/adapter.ps1 -AspectJHome C:/aspectj/lib
```

El script compila con `ajc -17` únicamente los fuentes de B y sus tres clases compartidas, muestra las introducciones del tejido y ejecuta `MainAOP`. Ante un fallo devuelve un error. La salida funcional es la misma que la indicada para A. La ejecución verificada está registrada en `evidencias/adapter-aop.txt`.

Sin el aspecto, `ImpresoraAntigua` no implementa `Impresora` y la asignación del cliente no compila. El adaptador OO permite seguir la delegación directamente y compilar con `javac`; AOP centraliza la adaptación sin añadir un objeto envoltorio, pero exige tejido y herramientas AspectJ.

## Enlaces

- [Repositorio](https://github.com/1Mejor2345/printer_company_team1)
- [Documento colaborativo](https://docs.google.com/document/d/1PgNbtRzagDtu18S4UhwMwKrN8vdNpoLTkBY7qKO93ew/edit)

Equipo: José Luis Paladines Sánchez, Julinho Jesús Plua Mendosa y Víctor Alfonso Marriott Espinoza.

## Notación UML

Los diagramas de clases usan compartimentos de nombre, atributos y operaciones; visibilidad `+`/`-`, miembros estáticos subrayados y tipos de parámetros y retornos. Adapter es por objeto: realización de `Impresora` (línea discontinua con triángulo hueco) y asociación navegable hacia `ImpresoraAntigua`, con multiplicidad 1 bajo el supuesto de referencia no nula. No se usa composición porque el objeto antiguo se crea fuera del adaptador. Singleton muestra el constructor privado y el atributo y método estáticos. Cada diagrama es una vista del patrón, no un inventario de todas las dependencias del programa.

La presentación sigue los ejemplos de clase de `05LenguajeUnificadoModelado` (pp. 54-56), `08PatronesEstructurales` (p. 13, Adapter Objeto) y `07PatronesDiseño` (p. 42, Singleton). Las diapositivas no se redistribuyen en este repositorio.
