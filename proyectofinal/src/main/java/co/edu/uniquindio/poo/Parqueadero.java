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
                System.out.println("Vehículo con placa " + vehiculo.getNumeroPlaca()
                        + " ha sido colocado en el puesto [" + i + "][" + j + "]");
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
                    System.out.print("[" + vehiculo.getClass().getSimpleName().charAt(0) + "]");
                } else {
                    System.out.print("[L]");
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
    
    
    public void calcularTotalPagar(Administrador tarifas) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo:");
        //System.out.println("llega aca1");
        Vehiculo vehiculo = registroVehiculos.get(placa);
        if (vehiculo != null) {
            LocalDateTime salida = LocalDateTime.now();
            //System.out.println("llega aca2");
            double tarifa = tarifas.get(vehiculo.getClass().getSimpleName());

           // System.out.println("llega aca3");
            Duration duracion = Duration.between(vehiculo.getHoraIngreso(), salida);
            long horas = duracion.toHours();
            if (duracion.toMinutesPart() > 0) { // Cobrar hora adicional 
                horas++;
            }
            double totalPagar = horas * tarifa;
            totalDiario += totalPagar;
            totalMensual += totalPagar;
            System.out.println("El total a pagar por el vehículo con placa " + placa + " es: " + totalPagar);
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

    public void calcularTotalPagar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalPagar'");
    }

}
