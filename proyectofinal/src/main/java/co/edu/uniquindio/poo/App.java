package co.edu.uniquindio.poo;

import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        
        String nombreParqueadero = JOptionPane.showInputDialog("Ingrese el nombre del Parqueadero:");

        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas del parqueadero:"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas del parqueadero:"));
        System.out.println("ingrese el nombre y documento del administrador");
        String nombre=scanner.nextLine();
        String documento=scanner.nextLine();
        Administrador admi= new Administrador(nombre,documento );
        Parqueadero parqueadero = new Parqueadero(nombreParqueadero, filas, columnas);
        parqueadero.estadoActual();
        String m2="bienvenido a "+nombreParqueadero+" parqueadero";
        JOptionPane.showMessageDialog(null, m2);
        int opcion = 0;
        while (opcion != 8) {
            String mensaje="Menú\n seleccione una opcion\n 1-Configurar tarifas administrador\n 2-Ingresar un nuevo vehiculo\n 3-Mostrar todos los vehiculos registrado\n 4-Mostrar estado actual del parqueadero\n 5-Eliminar un vehiculo \n 6-Tarifas\n 7-Calcular total a pagar por vehiculo\n 8-generar reporte ganancias\n 9-Cerrar parqueadero";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch (opcion) {
                case 1:
                    admi.configurarTarifas();
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
                    admi.imprimirTarifas(admi);
                    break;

                case 7:
                    parqueadero.calcularTotalPagar();
                    break;
                case 8: 
                    parqueadero.generarReporte();
                    break;
                case 9:
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
