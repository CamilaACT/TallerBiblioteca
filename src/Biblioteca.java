import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<Libro>();
    }
    public boolean addLibro(Libro lb){
        if(busquedaLibro(lb.getNombre())==null){
            libros.add(lb);
            return true;
        }else{
            return false;
        }

    }

    public Libro busquedaLibro(String nombre){
        for (Libro libro1 : libros) {
            if(libro1.getNombre().equals(nombre)){
                return libro1;
            }
        }
        return null;
    }

    public Libro busquedaBinario(int Id){
        int izquierda = 0;
        int derecha = libros.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (libros.get(medio).getId() == Id) {
                return libros.get(medio);
            } else if (libros.get(medio).getId() < Id) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public int sumaRecursivo(List<Libro> libros, int indice){
        if(indice==0){
            return libros.get(0).getNumPaginas();
        }else{
            return libros.get(indice).getNumPaginas()+sumaRecursivo(libros,indice-1);
        }
    }
    public Libro removeLibroPorNombre(String nombre){
        Libro libro1;
        for (int i=0;i<libros.size();i++) {
            libro1=libros.get(i);
            if(libro1.getNombre().equals(nombre)){
                libros.remove(i);
                return libro1;
            }
        }
        return null;
    }

    public Libro removeLibroPorId(int id){
        Libro libro1;
        for (int i=0;i<libros.size();i++) {
            libro1=libros.get(i);
            if(libro1.getId()==id){
                libros.remove(i);
                return libro1;
            }
        }
        return null;
    }
    public void QuemarDatos(){
        libros.add(new Libro("Libro1",25));
        libros.add(new Libro("Libro2",25));
        libros.add(new Libro("Libro3",25));
        libros.add(new Libro("Libro4",25));
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                "}\n";
    }

    public List<Libro> getLibros() {
        return libros;
    }
}







