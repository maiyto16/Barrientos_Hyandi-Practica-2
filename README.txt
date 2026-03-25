# Práctica 2 (Playlist) - Estructuras de Datos

Nombre completo: Hyandi Maya Barrientos Quiroz
Número de cuenta: 322227840
Correo electrónico: maiyto.16@ciencias.unam.mx

# Funcionamiento del programa

En esta práctica hice un programa que simula una playlist.

Cada canción se representa con una clase llamada `Cancion`, 
que guarda su *título*, *artista* y *duración en segundso*.  
Y la playlist se controla desde la clase `Reproductor`, y el 
programa se ejecuta desde consola por medio de un menú.

Desde ese menú se pueden hacer las operaciones principales que pedía la práctica:

- agregar una canción al inicio
- agregar una canción al final
- eliminar una canción por su título
- buscar una canción por su título
- mostrar la playlist
- mostrar la duración total
- reproducir la canción actual
- pasar a la siguiente canción
- regresar a la canción anterior
- eleguir canciónn favorita

También dejé una playlist inicial.

# Uso de la lista doblemente ligada

En este caso usé una **lista doblemente ligada** porque era la mejor opción 
para la playlist, sobre todo por la parte de avanzar y regresar entre canciones.

Usé principalmente el **iterador** para recorrer la lista y localizar canciones ya
que al \no estaba segura de si sí podía modificar los archivos base, ya que la 
clase Nodo no es publica asi que decidi usar el iterador para no modificar los 
archivos base.

Por eso, en lugar de manipular nodos directamente, varias operaciones se resolvieron 
recorriendo la lista con el iterador.  


# Archivos principales

- `Cancion.java`: representa cada canción.
- `Reproductor.java`: controla la playlist y la reproducción.
- `Main.java`: contiene el menú principal.
- `ListaDoblementeLigada.java`: lista usada para guardar la playlist.
- `Listable.java`: interfaz base de la lista.

