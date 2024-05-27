package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

import javax.swing.JOptionPane;

public class Parqueadero {
    private String nombreParqueadero;
    private static int filas;
    private static int columnas;
    private static Puesto[][] puestos;
    private Map<String, Vehiculo> registroVehiculos;
    private Map<String, Double> tarifas;
    private double totalDiario;
    private double totalMensual;

    public Parqueadero(String nombreParqueadero, int filas, int columnas) {
        this.nombreParqueadero = nombreParqueadero;
        this.filas = filas;
        this.columnas = columnas;
        this.puestos = new Puesto[filas][columnas];
        this.registroVehiculos = new HashMap<>();
        this.tarifas = new HashMap<>();
        inicializarPuestos();
    }
//--se crea parqueadero-- iniciliza los puestos--//
    private void inicializarPuestos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    /*public void configurarTarifas() {
        double tarifaCarro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para carros:"));
        double tarifaMoto = Double
                .parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para motos clásicas:"));
        double tarifaMotoHibrida = Double
                .parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para motos híbridas:"));
        tarifas.put("Carro", tarifaCarro);
        tarifas.put("Moto", tarifaMoto);
        tarifas.put("MotoHibrida", tarifaMotoHibrida);
        JOptionPane.showMessageDialog(null, "Tarifas configuradas correctamente.");
    }*/
    //--se valida el ingreso del vehiculo al puesto seleccionado--//
    public void ocuparPuesto(Vehiculo vehiculo, int i, int j) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            if (puestos[i][j].ocupar(vehiculo)) {
                //--se solicita la hora de ingreso como pluzze para en calcular total se pueda traer el tiempo y asi poder gestionar la multiplicacion--//
                vehiculo.setHoraIngreso(LocalDateTime.now()); // Establecer la hora de ingreso
                System.out.println("Vehículo con placa " + vehiculo.getNumeroPlaca()
                        + " ha sido colocado en el puesto [" + i + "][" + j + "]");
                JOptionPane.showMessageDialog(null, "Vehículo con placa " + vehiculo.getNumeroPlaca()
                + " ha sido colocado en el puesto [" + i + "][" + j + "]");
                //--agrega el vehiculo con la placa--//
                registroVehiculos.put(vehiculo.getNumeroPlaca(), vehiculo);
            } else {
                System.out.println("El puesto [" + i + "][" + j + "] ya está ocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }
    //--calcula el total a pagar por las horas de uso del parqueadero--//
    public void calcularTotalPagar() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo:");
        Vehiculo vehiculo = registroVehiculos.get(placa);
        if (vehiculo != null) {
            LocalDateTime salida = LocalDateTime.now();//genera la salida del vehiculo
            String tipoVehiculo = vehiculo.getClass().getSimpleName();
            double tarifa = getTarifa(tipoVehiculo); // Usar el método para obtener la tarifa
            if (tarifa != 0.0) {
                Duration duracion = Duration.between(vehiculo.getHoraIngreso(), salida);
                long horas = duracion.toHours();
                double totalPagar = horas * tarifa;
                totalDiario += totalPagar;
                totalMensual += totalPagar;
                System.out.println("El total a pagar por el vehículo con placa " + placa + " es: " + totalPagar);
            } else {
                System.out.println("No se ha configurado una tarifa para el tipo de vehículo: " + tipoVehiculo);
            }
        } else {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
    }
//--se trae la tarifa --//
    public double getTarifa(String tipoVehiculo) {

        if (tarifas.containsKey(tipoVehiculo)) {
            return tarifas.get(tipoVehiculo);
        } else {

            return 0.0;
        }
    }
    //---se muestra los vehiculos con sus respectivos datos--//
    public void mostrarVehiculos() {

        StringBuilder vehiculosStr = new StringBuilder();
        registroVehiculos.values().forEach(vehiculo -> vehiculosStr.append(vehiculo).append("\n"));

        JOptionPane.showMessageDialog(null, vehiculosStr.toString(), nombreParqueadero,
                JOptionPane.INFORMATION_MESSAGE);
    }
//--actualiza el estado del parqueadero --//
    public static void estadoActual() {
        StringBuilder estadoParqueadero = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Puesto puesto = puestos[i][j];
                if (puesto.ocupado()) {
                    Vehiculo vehiculo = puesto.getVehiculo();
                    estadoParqueadero.append("[").append(vehiculo.getClass().getSimpleName().charAt(0)).append("]");
                } else {
                    estadoParqueadero.append("[L]");
                }
                estadoParqueadero.append("\t");
            }
            estadoParqueadero.append("\n");
        }

        JOptionPane.showMessageDialog(null, estadoParqueadero.toString(), "Matriz de Puestos",
                JOptionPane.INFORMATION_MESSAGE);
    }
//---metodo para eliminar los vehiculos con su numero de placa--/
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
//---generar reporte --//
    public void generarReporte() {
        System.out.println("Reporte Diario:");
        System.out.println("Total recaudado: " + totalDiario);

        System.out.println("Reporte Mensual:");
        System.out.println("Total recaudado: " + totalMensual);

    }

}