package co.edu.uniquindio.poo;

public class Puesto {
    private int fila;
    private int columna;
    private Vehiculo vehiculo;
//-- puesto clase para crear parqueadero --//
    public Puesto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.vehiculo = null;
    }
//-- se maneja en el metodo de ocuparpuesto para guardar vehiculo enn clase parqueadero--//
    public boolean ocupar(Vehiculo vehiculo) {
        if (this.vehiculo == null) {
            this.vehiculo = vehiculo;
            return true;
        }
        return false;
    }
//--se maneja en el metodo eliminar vehiculo para dejar libre el espacio del parqueadero--//
    public void liberar() {
        this.vehiculo = null;
    }
//--se da en la posicion de  estadoactual de parqueadero mostrando el vehiculo--//
    public boolean ocupado() {
        return vehiculo != null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

}
