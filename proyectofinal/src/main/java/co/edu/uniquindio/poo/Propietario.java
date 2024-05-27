package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Propietario extends Persona {
    private static Scanner scanner = new Scanner(System.in);

    public Propietario(String nombre, String documento) {
        super(nombre, documento);
    }

    public static Propietario crearPropietario() {
        System.out.println("Ingrese el nombre del propietario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el documento del propietario:");
        String documento = scanner.nextLine();

        return new Propietario(nombre, documento);
    }

}
