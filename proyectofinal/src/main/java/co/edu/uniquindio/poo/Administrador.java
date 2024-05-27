package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Administrador extends Persona {
     private Map<String, Double> tarifas;
     private double totalDiario;
     private double totalMensual;
     private Map<String, Vehiculo> registroVehiculos;
     
    public Administrador(String nombre, String documento){
        super(nombre,documento);
         this.tarifas = new HashMap<>();
        
    }
    public void configurarTarifas() {
        tarifas.put("Carro", Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por hora para Carro:")));
        tarifas.put("Moto", Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por hora para Moto:")));
        tarifas.put("MotoHibrida", Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por hora para Moto Hibrida:")));
        JOptionPane.showMessageDialog(null, "Precios configurados correctamente.");
    }
    public void imprimirTarifas(Administrador admin) {
        Map<String, Double> tarifas = admin.getTarifas();
        System.out.println("Tarifas del parqueadero:");
        tarifas.forEach((tipo, tarifa) -> {
            String m3=("Tipo de vehículo: " + tipo + " - Tarifa por hora: " + tarifa);
            
            JOptionPane.showMessageDialog(null, m3, "Tarifas", 0);
        });
    }
   


    public double getTarifa(String tipoVehiculo) {
        return tarifas.getOrDefault(tipoVehiculo, 0.0);
    }

    public Map<String, Double> getTarifas() {
        return new HashMap<>(tarifas);
    }


      
    
}
