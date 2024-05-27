package co.edu.uniquindio.poo;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/*
*@Manuela Puerta
*@Juan Carmona
 * Se usa la clase App para ser la que ejecute todo el codigo.
 */
//--clase ventana donde se estaba creando la interfaz grafica pero por daños y errores se dejo a media--//
public class Ventana extends JFrame {
    private static Scanner scanner = new Scanner(System.in);
    public ImageIcon icono;

    private JLabel titulo;
    private JLabel descripcion;
    private JLabel menu, m1, m2, m3, m4;

    public Ventana() {

        // ventana improvisada
        JFrame vn = new JFrame("parqueadero");
        //String nombreParqueadero = Parqueadero.crearParqueadero();
        //Parqueadero.tamañoParqueadero();

        Font fuente = new Font("arabella", Font.ITALIC, 20);
        setTitle("Parqueadero");
        setLocationRelativeTo(null);
        setLayout(null);
        descripcion = new JLabel(" Bienvenid@ a " + " Parqueadero");
        descripcion.setBounds(75, 0, 350, 50);
        descripcion.setFont(fuente);
        descripcion.setForeground(Color.white);
        add(descripcion);
        titulo = new JLabel("Menú");
        titulo.setFont(fuente);
        titulo.setBounds(175, 20, 250, 70);
        titulo.setForeground(Color.white);
        add(titulo);
        menu = new JLabel("Seleccione una opcion");
        m1 = new JLabel("1-Seleccione rol");
        m2 = new JLabel("2-Ingresar un nuevo vehiculo");
        m3 = new JLabel("3-Mostrar todos los vehiculos del parqueadero");
        m4 = new JLabel("4-Eliminar un vehiculo");

        // menu.setText("Seleccione una opcion\n 1-Seleccione rol\n 2-Ingresar un nuevo
        // vehiculo\\n 3-Mostrar todos los vehiculos del parqueadero")
        menu.setFont(fuente);
        m1.setFont(fuente);
        m2.setFont(fuente);
        m3.setFont(fuente);
        m4.setFont(fuente);
        menu.setBounds(120, 30, 255, 110);
        m1.setBounds(30, 45, 275, 120);
        m2.setBounds(30, 55, 300, 140);
        m3.setBounds(30, 65, 425, 160);
        m4.setBounds(30, 78, 255, 170);
        menu.setForeground(Color.white);
        m1.setForeground(Color.white);
        m2.setForeground(Color.white);
        m3.setForeground(Color.white);
        m4.setForeground(Color.white);
        add(menu);
        add(m1);
        add(m2);
        add(m3);
        add(m4);

        this.getContentPane().setBackground(new java.awt.Color(84, 172, 253));

    //ventana improvisada 
    //JFrame vn = new JFrame("parqueadero");
    //String nombreParqueadero = Parqueadero.crearParqueadero();
    //Parqueadero.tamañoParqueadero();


        //Font fuente=new Font("arabella",Font.ITALIC,20);
        setTitle("Parqueadero");
        setLocationRelativeTo(null);
        setLayout(null);
        descripcion= new JLabel(" Bienvenid@ a "+" Parqueadero");
        descripcion.setBounds(75,0,350,50);
        descripcion.setFont(fuente);
        descripcion.setForeground(Color.white);
        add(descripcion);
        titulo= new JLabel("Menú" );
        titulo.setFont(fuente);
        titulo.setBounds(175,20,250,70);
        titulo.setForeground(Color.white);
        add(titulo);
        menu=new JLabel("Seleccione una opcion");
        m1=new JLabel("1-Seleccione rol");
        m2=new JLabel("2-Ingresar un nuevo vehiculo");
        m3=new JLabel("3-Mostrar todos los vehiculos del parqueadero");
        m4=new JLabel("4-Eliminar un vehiculo");
        
        //menu.setText("Seleccione una opcion\n 1-Seleccione rol\n 2-Ingresar un nuevo vehiculo\\n 3-Mostrar todos los vehiculos del parqueadero")
        menu.setFont(fuente);m1.setFont(fuente);m2.setFont(fuente);m3.setFont(fuente);m4.setFont(fuente);
        menu.setBounds(120,30,255,110);
        m1.setBounds(30,45,275,120);
        m2.setBounds(30,55,300,140);m3.setBounds(30,65,425,160);m4.setBounds(30,78,255,170);
        menu.setForeground(Color.white);m1.setForeground(Color.white);m2.setForeground(Color.white);m3.setForeground(Color.white);m4.setForeground(Color.white);
        add(menu);add(m1);add(m2);add(m3);add(m4);
        

        this.getContentPane().setBackground(new java.awt.Color(84, 172, 253));
        

    }
    }


