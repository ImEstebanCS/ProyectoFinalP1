package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private String velocidadMaxima;

    public Moto(String numeroPlaca, String modelo, Propietario propietario, String velocidadMaxima) {
        super(numeroPlaca, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getVelocidadMaxima() {
        return velocidadMaxima;
    }

}
