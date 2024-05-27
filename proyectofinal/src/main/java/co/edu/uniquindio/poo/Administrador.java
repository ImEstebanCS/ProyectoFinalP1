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

        public <tarifas> Map<String, Double>  configurarTarifas() {
        double tarifaCarro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para carros:"));
        double tarifaMoto = Double
                .parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para motos clásicas:"));
        double tarifaMotoHibrida = Double
                .parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora para motos híbridas:"));
        tarifas.put("Carro", tarifaCarro);
        tarifas.put("Moto", tarifaMoto);
        tarifas.put("MotoHibrida", tarifaMotoHibrida);
        JOptionPane.showMessageDialog(null, "Tarifas configuradas correctamente.");
        return tarifas;
    }
    public double getTarifa(Vehiculo vehiculo) {
        return tarifas.getOrDefault(vehiculo, 0.0);
    }

        public long get(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'get'");
        }

        public long get(Vehiculo vehiculo) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'get'");
        }

      
    
}
