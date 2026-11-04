# Sistema de impresiones - Team 01

Tarea 01 de Diseño de Software (ESPOL): patrones de diseño **Adapter** y **Singleton**.

## Sección A - Programación orientada a objetos (implementada)

Ejemplo: una aplicación usa el método `imprimir()`, mientras que una impresora antigua solo ofrece `imprimirTexto()`. El adaptador permite reutilizarla sin modificar la clase antigua. Un gestor Singleton cuenta las impresiones desde un único objeto.

| Archivo | Función |
| --- | --- |
| `poo/Impresora.java` | Interfaz que define el método moderno. |
| `poo/ImpresoraAntigua.java` | Clase con el método heredado. |
| `poo/AdaptadorImpresora.java` | Implementa `Impresora` y delega en la clase antigua. |
| `poo/GestorImpresiones.java` | Singleton que centraliza el contador. |
| `poo/Main.java` | Demuestra ambos patrones. |
| `uml/*.dot` | Diagramas UML editables con Graphviz. |

### Ejecución en VS Code (JDK 17 o superior)

1. Clonar el repositorio y abrirlo en Visual Studio Code.
2. Abrir la terminal integrada.
3. Ejecutar:

```bash
cd poo
javac *.java
java Main
```

Salida esperada:

```text
Impresora antigua: Tarea de Java
Impresora antigua: Diagrama UML
Mismo gestor: true
Total de impresiones: 2
```

Para el informe, tomar **capturas auténticas de VS Code** mostrando el código Java, los diagramas UML y la terminal integrada con el resultado de la ejecución. Las imágenes aún deben realizarse en el equipo del grupo.

## Secciones pendientes para el equipo

- **B - Adapter con AspectJ:** implementar y comparar con la versión OO.
- **C - Singleton con AspectJ:** implementar y comparar con la versión OO.

Las secciones B y C **no están implementadas todavía**. Partir de este ejemplo, mantener la versión OO y añadir el código AspectJ en carpetas independientes. No presentar capturas simuladas.

## Enlaces

- [Repositorio](https://github.com/1Mejor2345/printer_company_team1)
- [Documento colaborativo](https://docs.google.com/document/d/1PgNbtRzagDtu18S4UhwMwKrN8vdNpoLTkBY7qKO93ew/edit)

Equipo: José Luis Paladines Sánchez, Julinho Jesús Plua Mendosa y Víctor Alfonso Marriott Espinoza.
