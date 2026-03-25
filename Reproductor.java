import java.util.Iterator;

public class Reproductor {

    /* Playlist del reproductor. */
    private ListaDoblementeLigada<Cancion> playlist;

    /* Cancion actual. */
    private Cancion actual;

    /* Indice de la cancion actual. */
    private int indiceActual;

    /**
     * Constructor del reproductor.
     */
    public Reproductor() {
        playlist = new ListaDoblementeLigada<>();
        actual = null;
        indiceActual = -1;
    }

    /**
     * Agrega una cancion al inicio.
     */
    public void agregarCancionAlInicio(String titulo, String artista, int duracion) {
        Cancion nueva = new Cancion(titulo, artista, duracion);
        playlist.agregar(0, nueva);

        if (actual == null) {
            actual = nueva;
            indiceActual = 0;
        } else {
            indiceActual++;
        }
    }

    /**
     * Agrega una cancion al final.
     */
    public void agregarCancionAlFinal(String titulo, String artista, int duracion) {
        Cancion nueva = new Cancion(titulo, artista, duracion);
        playlist.agregar(nueva);

        if (actual == null) {
            actual = nueva;
            indiceActual = 0;
        }
    }

    /**
     * Elimina una cancion por titulo.
     */
    public boolean eliminarCancionPorTitulo(String titulo) {
        int total = cantidadCanciones();
        int indiceEliminar = buscarIndicePorTitulo(titulo);

        if (indiceEliminar == -1) {
            return false;
        }

        Cancion eliminada = obtenerCancion(indiceEliminar);

        if (total == 1) {
            playlist.vacia();
            actual = null;
            indiceActual = -1;
            return true;
        }

        playlist.eliminar(eliminada);

        if (indiceEliminar < indiceActual) {
            indiceActual--;
        } else if (indiceEliminar == indiceActual) {
            if (indiceActual >= cantidadCanciones()) {
                indiceActual = cantidadCanciones() - 1;
            }
        }

        if (cantidadCanciones() > 0) {
            actual = obtenerCancion(indiceActual);
        } else {
            actual = null;
            indiceActual = -1;
        }

        return true;
    }

    /**
     * Busca una cancion por titulo.
     */
    public Cancion buscarCancionPorTitulo(String titulo) {
        Iterator<Cancion> it = playlist.iterador();

        while (it.hasNext()) {
            Cancion c = it.next();
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return c;
            }
        }

        return null;
    }

    /**
     * Marca una cancion como favorita.
     */
    public boolean marcarFavorita(String titulo) {
        Cancion c = buscarCancionPorTitulo(titulo);

        if (c == null) {
            return false;
        }

        c.setFavorita(true);
        return true;
    }

    /**
     * Muestra la playlist.
     */
    public void mostrarPlaylist() {
        if (cantidadCanciones() == 0) {
            System.out.println("La playlist esta vacia.");
            return;
        }

        System.out.println("\nPlaylist actual");
        Iterator<Cancion> it = playlist.iterador();
        int i = 0;

        while (it.hasNext()) {
            Cancion c = it.next();
            if (i == indiceActual) {
                System.out.println("> " + (i + 1) + ". " + c);
            } else {
                System.out.println((i + 1) + ". " + c);
            }
            i++;
        }
    }

    /**
     * Calcula la duracion total.
     */
    public int calcularDuracionTotal() {
        int total = 0;
        Iterator<Cancion> it = playlist.iterador();

        while (it.hasNext()) {
            total += it.next().getDuracionSegundos();
        }

        return total;
    }

    /**
     * Muestra la cancion actual.
     */
    public void reproducirActual() {
        if (actual == null) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }

        System.out.println("\nReproduciendo:");
        System.out.println(actual.getTitulo() + " - " + actual.getArtista());
        System.out.println("Duracion: " + actual.getDuracionSegundos() + " s");
    }

    /**
     * Cambia a la siguiente cancion.
     */
    public void siguienteCancion() {
        int total = cantidadCanciones();

        if (total == 0) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }

        if (indiceActual < total - 1) {
            indiceActual++;
        } else {
            indiceActual = 0;
        }

        actual = obtenerCancion(indiceActual);
        System.out.println("Se cambio a la siguiente cancion.");
    }

    /**
     * Cambia a la cancion anterior.
     */
    public void cancionAnterior() {
        int total = cantidadCanciones();

        if (total == 0) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }

        if (indiceActual > 0) {
            indiceActual--;
            actual = obtenerCancion(indiceActual);
            System.out.println("Se regreso a la cancion anterior.");
        } else {
            System.out.println("Ya estas en la primera cancion.");
        }
    }

    /**
     * Cuenta los elementos de la playlist.
     */
    private int cantidadCanciones() {
        int contador = 0;
        Iterator<Cancion> it = playlist.iterador();

        while (it.hasNext()) {
            it.next();
            contador++;
        }

        return contador;
    }

    /**
     * Regresa la cancion en la posicion indicada.
     */
    private Cancion obtenerCancion(int indice) {
        if (indice < 0) {
            return null;
        }

        Iterator<Cancion> it = playlist.iterador();
        int i = 0;

        while (it.hasNext()) {
            Cancion c = it.next();
            if (i == indice) {
                return c;
            }
            i++;
        }

        return null;
    }

    /**
     * Busca el indice de una cancion por titulo.
     */
    private int buscarIndicePorTitulo(String titulo) {
        Iterator<Cancion> it = playlist.iterador();
        int i = 0;

        while (it.hasNext()) {
            Cancion c = it.next();
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
