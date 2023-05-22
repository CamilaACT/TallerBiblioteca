public class Libro {
    private String Nombre;
    private int Id;
    private int numPaginas;
    private static int contador=0;

    public Libro(String nombre, int numPaginas) {
        Nombre = nombre;
        this.numPaginas = numPaginas;
        this.Id=asignarID();
    }

    private int asignarID(){
        contador=contador+1;
        return contador;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getId() {
        return Id;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Nombre='" + Nombre + '\'' +
                ", Id=" + Id +
                ", numPaginas=" + numPaginas +
                "\n";
    }
}
