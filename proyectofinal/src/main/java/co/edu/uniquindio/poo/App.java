package co.edu.uniquindio.poo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String nombreParqueadero = JOptionPane.showInputDialog("Ingrese el nombre del Parqueadero:");
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas del parqueadero:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas del parqueadero:"));

        Parqueadero parqueadero = new Parqueadero(nombreParqueadero, filas, columnas);
        Parqueadero.estadoActual();

        int opcion = 0;
        while (opcion != 8) {
            System.out.println(
                    "Bienvenido al parqueadero " + nombreParqueadero + "\nPor favor seleccione la opción que deseé");
            System.out.println("1-Configurar tarifas");
            System.out.println("2-Ingresar un nuevo vehiculo");
            System.out.println("3-Mostrar todos los vehiculos del parqueadero");
            System.out.println("4-Mostrar estado actual del parqueadero");
            System.out.println("5-Eliminar un vehiculo");
            System.out.println("6-Calcular total a pagar por vehiculo");
            System.out.println("7-Generar reporte ganancias");
            System.out.println("8-Cerrar parqueadero");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    parqueadero.configurarTarifas();
                    break;
                case 2:
                    Vehiculo.agregarVehiculo(parqueadero);
                    break;
                case 3:
                    parqueadero.mostrarVehiculos();
                    break;
                case 4:
                    parqueadero.estadoActual();
                    break;
                case 5:
                    parqueadero.eliminarVehiculo();
                    break;
                case 6:
                    parqueadero.calcularTotalPagar();
                    break;
                case 7:
                    parqueadero.generarReporte();
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}
