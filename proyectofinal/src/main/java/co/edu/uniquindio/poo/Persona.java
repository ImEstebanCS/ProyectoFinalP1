package co.edu.uniquindio.poo;

public class Persona {
    protected String nombre;
    protected String documento;

    public Persona(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;

    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre='" + nombre + '\'' + ", Documento=" + documento + '}';
    }
}
