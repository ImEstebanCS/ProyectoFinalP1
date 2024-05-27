package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

import javax.swing.JOptionPane;

public class Parqueadero {
    private String nombreParqueadero;
    private int filas;
    private int columnas;
    private Puesto[][] puestos;
    private Map<String, Vehiculo> registroVehiculos;
    
    private double totalDiario;
    private double totalMensual;

    public Parqueadero(String nombreParqueadero, int filas, int columnas) {
        this.nombreParqueadero = nombreParqueadero;
        this.filas = filas;
        this.columnas = columnas;
        this.puestos = new Puesto[filas][columnas];
        this.registroVehiculos = new HashMap<>();
        inicializarPuestos();
    }

    private void inicializarPuestos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

  

    public void ocuparPuesto(Vehiculo vehiculo, int i, int j) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            if (puestos[i][j].ocupar(vehiculo)) {
                vehiculo.setHoraIngreso(LocalDateTime.now()); // Establecer la hora de ingreso
                String m1=("Vehículo con placa " + vehiculo.getNumeroPlaca()
                + " ha sido colocado en el puesto [" + i + "][" + j + "]");
                System.out.println(m1);
                JOptionPane.showMessageDialog(null, m1);
                registroVehiculos.put(vehiculo.getNumeroPlaca(), vehiculo);
            } else {
                System.out.println("El puesto [" + i + "][" + j + "] ya está ocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    

    public void mostrarVehiculos() {
        registroVehiculos.values().forEach(System.out::println);
    }

    public void estadoActual() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Puesto puesto = puestos[i][j];
                if (puesto.ocupado()) {
                    Vehiculo vehiculo = puesto.getVehiculo();
                    String m3="[" + vehiculo.getClass().getSimpleName().charAt(0) + "]";
                    System.out.print(m3);
                    JOptionPane.showMessageDialog(null,m3);
                } else {
                    JOptionPane.showMessageDialog(null,"[L]");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void eliminarVehiculo() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo que desea eliminar:");
        Vehiculo vehiculo = registroVehiculos.remove(placa);
        if (vehiculo != null) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (puestos[i][j].getVehiculo() == vehiculo) {
                        puestos[i][j].liberar();
                        System.out.println(
                                "Vehículo con placa " + placa + " eliminado del puesto [" + i + "][" + j + "]");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
    }

    public void generarReporte() {
        System.out.println("Reporte Diario:");
        System.out.println("Total recaudado: " + totalDiario);

        System.out.println("Reporte Mensual:");
        System.out.println("Total recaudado: " + totalMensual);

    }

   

}
