package co.edu.uniquindio.poo;

public class Persona {
    protected static String nombre;
    protected static String documento;

    public Persona(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;

    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre='" + nombre + '\'' + ", Documento=" + documento + '}';
    }
}
