public class Cancion {

    /* Titulo de la cancion. */
    private String titulo;

    /* Artista de la cancion. */
    private String artista;

    /* Duracion en segundos. */
    private int duracionSegundos;

    /* Indica si la cancion es favorita. */
    private boolean favorita;

    /**
     * Constructor de la cancion.
     */
    public Cancion(String titulo, String artista, int duracionSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
        this.favorita = false;
    }

    /**
     * Regresa el titulo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Regresa el artista.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Regresa la duracion.
     */
    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    /**
     * Indica si es favorita.
     */
    public boolean esFavorita() {
        return favorita;
    }

    /**
     * Cambia el estado de favorita.
     */
    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    /**
     * Regresa la representacion en cadena.
     */
    @Override
    public String toString() {
        String texto = titulo + " - " + artista + " (" + duracionSegundos + " s)";
        if (favorita) {
            texto += " [❤️]";
        }
        return texto;
    }
}
