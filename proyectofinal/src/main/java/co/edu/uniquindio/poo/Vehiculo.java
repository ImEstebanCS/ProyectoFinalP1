package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
        String mensaje="Seleccione el tipo de vehiculo a agregar\n 1-carro\n 2-Moto\n 3-Moto Hibrida";
            int tipo=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            Propietario propietario = Propietario.crearPropietario();
            String numeroPlaca =JOptionPane.showInputDialog("Ingrese el numeroPlaca del Vehiculo;");
            String modelo = JOptionPane.showInputDialog("ingrese el modelo del vehiculo");
            String m4="Ingrese la posición donde desea guardar su vehiculo (i j):";
            System.out.println("Ingrese la posición donde desea guardar su vehiculo (i j):");
            int posicioni = Integer.parseInt(JOptionPane.showInputDialog(m4));
            int posicionj = Integer.parseInt(JOptionPane.showInputDialog(m4));
      

        Vehiculo vehiculo = null;
        switch (tipo) {
            case 1:
                vehiculo = new Carro(numeroPlaca, modelo, propietario);
                break;
            case 2:
                String mensagMoto="ingrese la velocidad maxima de la moto";
                String velocidadMaxima=JOptionPane.showInputDialog(mensagMoto);
                String mensajeFmoto=JOptionPane.showInputDialog(null, "Vehiculo moto agregada correctamente\n 1-para volver a menu anterior");
                System.out.println("Vehiculo agregado correctamente\n ");    
                vehiculo = new Moto(numeroPlaca, modelo, propietario, velocidadMaxima);
                break;
            case 3:
                String mensagMotoE="ingrese la velocidad maxima de la moto Hibrida";
                String velocidadMaximaElectrica=JOptionPane.showInputDialog(mensagMotoE);
                String mensajeFmoto2=JOptionPane.showInputDialog(null, "Vehiculo moto electrica agregada correctamente\n 1-para volver a menu anterior");
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
