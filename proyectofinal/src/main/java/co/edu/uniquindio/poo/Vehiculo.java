package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Vehiculo {
    private static Scanner scanner = new Scanner(System.in);
    private String numeroPlaca;
    private String modelo;
    private Propietario propietario;
    private LocalDateTime horaIngreso;

    public Vehiculo(String numeroPlaca, String modelo, Propietario propietario) {
        this.numeroPlaca = numeroPlaca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.horaIngreso = LocalDateTime.now();
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "numeroPlaca='" + numeroPlaca + '\'' + ", modelo='" + modelo + '\'' + ", propietario="
                + propietario + ", horaIngreso=" + horaIngreso + '}';
    }

    public static void agregarVehiculo(Parqueadero parqueadero) {
        System.out.println("Seleccione el tipo de vehiculo que desea agregar");
        System.out.println("1-Carro\n2-Motocicleta\n3-Motocicleta eléctrica");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        Propietario propietario = Propietario.crearPropietario();
        System.out.println("Ingrese el numero de placa del Vehiculo:");
        String numeroPlaca = scanner.nextLine();
        System.out.println("Ingrese el modelo del Vehiculo:");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese la posición donde desea guardar su vehiculo (i j):");
        int posicioni = scanner.nextInt();
        int posicionj = scanner.nextInt();

        Vehiculo vehiculo = null;
        switch (tipo) {
            case 1:
                vehiculo = new Carro(numeroPlaca, modelo, propietario);
                break;
            case 2:
                System.out.println("Ingrese la velocidad maxima del Vehiculo:");
                String velocidadMaxima = scanner.next();
                vehiculo = new Moto(numeroPlaca, modelo, propietario, velocidadMaxima);
                break;
            case 3:
                System.out.println("Ingrese la velocidad maxima del Vehiculo:");
                String velocidadMaximaElectrica = scanner.next();
                vehiculo = new MotoHibrida(numeroPlaca, modelo, propietario, velocidadMaximaElectrica);
                break;
            default:
                System.out.println("Esta no es una opción valida.");
                return;
        }

        if (vehiculo != null) {
            parqueadero.ocuparPuesto(vehiculo, posicioni, posicionj);
        }
    }

}
