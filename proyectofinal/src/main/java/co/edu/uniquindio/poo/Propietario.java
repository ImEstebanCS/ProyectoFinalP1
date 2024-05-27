package co.edu.uniquindio.poo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Propietario extends Persona {
    private static Scanner scanner = new Scanner(System.in);

    public Propietario(String nombre, String documento) {
        super(nombre, documento);
        assert nombre != null && !nombre.isBlank();
        assert documento != null && !documento.isBlank();
    }
    //Metodo toString 
    public String toString() {
        return "Nombre: " + nombre + " " + ", Documento: " + documento;
    }

    public static Propietario crearPropietario() {
        nombre=JOptionPane.showInputDialog("Ingrese el nombre del propietario del vehiculo:");
        documento = JOptionPane.showInputDialog("Ingrese el documento del propietario del vehiculo:");
        return new Propietario(nombre, documento);
    }

    public Object getApellido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApellido'");
    }

    public Object getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public Object getDocumento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDocumento'");
    }

}
