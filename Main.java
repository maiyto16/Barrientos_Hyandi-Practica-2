import java.util.Scanner;

public class Main {

    /**
     * Ejecuta el menu del programa.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reproductor reproductor = new Reproductor();
        cargarPlaylistPrueba(reproductor);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    agregarCancionInicio(scanner, reproductor);
                    break;
                case 2:
                    agregarCancionFinal(scanner, reproductor);
                    break;
                case 3:
                    eliminarCancion(scanner, reproductor);
                    break;
                case 4:
                    buscarCancion(scanner, reproductor);
                    break;
                case 5:
                    reproductor.mostrarPlaylist();
                    break;
                case 6:
                    System.out.println("\nDuracion total: "
                            + reproductor.calcularDuracionTotal() + " segundos");
                    break;
                case 7:
                    reproductor.reproducirActual();
                    break;
                case 8:
                    reproductor.siguienteCancion();
                    reproductor.reproducirActual();
                    break;
                case 9:
                    reproductor.cancionAnterior();
                    reproductor.reproducirActual();
                    break;
                case 10:
                    marcarFavorita(scanner, reproductor);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Playlist inicial.
     */
    private static void cargarPlaylistPrueba(Reproductor reproductor) {
        reproductor.agregarCancionAlFinal("Divine Service", "Lies of P", 189);
        reproductor.agregarCancionAlFinal("Cordelia", "Juan Arenosa", 131);
        reproductor.agregarCancionAlFinal("Camelia", "Juan Arenosa", 147);
        reproductor.agregarCancionAlFinal("Ofelia", "Juan Arenosa", 167);
        reproductor.agregarCancionAlFinal("Luce", "Ludovico Einaudi", 427);
        reproductor.agregarCancionAlFinal("Reflections", "Toshifumi Hinata", 266);
        reproductor.agregarCancionAlFinal("Clair de Lune", "Claude Debussy", 300);
        reproductor.agregarCancionAlFinal("Amélie - Comptine d'un autre été, l'après-midi (reimagined)", "Andrea Vanzo", 195);
    }

    /**
     * Muestra las opciones del menu.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENU PLAYLIST ---");
        System.out.println("1. Agregar cancion al inicio");
        System.out.println("2. Agregar cancion al final");
        System.out.println("3. Eliminar cancion por titulo");
        System.out.println("4. Buscar cancion por titulo");
        System.out.println("5. Mostrar playlist");
        System.out.println("6. Mostrar duracion total");
        System.out.println("7. Reproducir cancion actual");
        System.out.println("8. Siguiente cancion");
        System.out.println("9. Cancion anterior");
        System.out.println("10. Marcar favorita");
        System.out.println("0. Salir");
    }

    /**
     * Lee los datos de una cancion y la agrega al inicio.
     */
    private static void agregarCancionInicio(Scanner scanner, Reproductor reproductor) {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        int duracion = leerEntero(scanner, "Duracion en segundos: ");

        reproductor.agregarCancionAlInicio(titulo, artista, duracion);
        System.out.println("Cancion agregada al inicio.");
    }

    /**
     * Lee los datos de una cancion y la agrega al final.
     */
    private static void agregarCancionFinal(Scanner scanner, Reproductor reproductor) {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        int duracion = leerEntero(scanner, "Duracion en segundos: ");

        reproductor.agregarCancionAlFinal(titulo, artista, duracion);
        System.out.println("Cancion agregada al final.");
    }

    /**
     * Lee un titulo y elimina la cancion correspondiente.
     */
    private static void eliminarCancion(Scanner scanner, Reproductor reproductor) {
        System.out.print("Titulo de la cancion a eliminar: ");
        String titulo = scanner.nextLine();

        if (reproductor.eliminarCancionPorTitulo(titulo)) {
            System.out.println("Cancion eliminada correctamente.");
        } else {
            System.out.println("No se encontro la cancion.");
        }
    }

    /**
     * Lee un titulo y busca la cancion correspondiente.
     */
    private static void buscarCancion(Scanner scanner, Reproductor reproductor) {
        System.out.print("Titulo de la cancion a buscar: ");
        String titulo = scanner.nextLine();

        Cancion encontrada = reproductor.buscarCancionPorTitulo(titulo);

        if (encontrada != null) {
            System.out.println("Cancion encontrada: " + encontrada);
        } else {
            System.out.println("No se encontro la cancion.");
        }
    }

    /**
     * Lee un titulo y marca la cancion como favorita.
     */
    private static void marcarFavorita(Scanner scanner, Reproductor reproductor) {
        System.out.print("Titulo de la cancion favorita: ");
        String titulo = scanner.nextLine();

        if (reproductor.marcarFavorita(titulo)) {
            System.out.println("Cancion marcada como favorita.");
        } else {
            System.out.println("No se encontro la cancion.");
        }
    }

    /**
     * Lee un numero entero.
     * Repite la lectura mientras la entrada no sea valida.
     */
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un numero entero.");
            }
        }
    }
}
