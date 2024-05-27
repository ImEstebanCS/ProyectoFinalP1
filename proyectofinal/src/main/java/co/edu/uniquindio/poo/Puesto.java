package co.edu.uniquindio.poo;

public class Puesto {
    private int fila;
    private int columna;
    private Vehiculo vehiculo;

    public Puesto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.vehiculo = null;
    }

    public boolean ocupar(Vehiculo vehiculo) {
        if (this.vehiculo == null) {
            this.vehiculo = vehiculo;
            return true;
        }
        return false;
    }

    public void liberar() {
        this.vehiculo = null;
    }

    public boolean ocupado() {
        return vehiculo != null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

}
